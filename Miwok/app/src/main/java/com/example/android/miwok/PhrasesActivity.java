package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Where are you going?", "minto wuksus",
                R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә",
                R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I'm coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new Word("Let's go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //
                audioManager = (AudioManager) Context.getSystemService(Context.AUDIO_SERVICE);
                playbackAttributes = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_GAME)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build();
                focusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
                        .setAudioAttributes(playbackAttributes)
                        .setAcceptsDelayedFocusGain(true)
                        .setOnAudioFocusChangeListener(afChangeListener, handler)
                        .build();
                mediaPlayer = new MediaPlayer();
                final Object focusLock = new Object();

                boolean playbackDelayed = false;
                boolean playbackNowAuthorized = false;

// ...
                int res = audioManager.requestAudioFocus(focusRequest);
                synchronized(focusLock) {
                    if (res == AudioManager.AUDIOFOCUS_REQUEST_FAILED) {
                        playbackNowAuthorized = false;
                    } else if (res == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        playbackNowAuthorized = true;
                        playbackNow();
                    } else if (res == AudioManager.AUDIOFOCUS_REQUEST_DELAYED) {
                        playbackDelayed = true;
                        playbackNowAuthorized = false;
                    }
                }

// ...
                @Override
                public void onAudioFocusChange(int focusChange) {
                    switch (focusChange) {
                        case AudioManager.AUDIOFOCUS_GAIN:
                            if (playbackDelayed || resumeOnFocusGain) {
                                synchronized(focusLock) {
                                    playbackDelayed = false;
                                    resumeOnFocusGain = false;
                                }
                                playbackNow();
                            }
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS:
                            synchronized(focusLock) {
                                resumeOnFocusGain = false;
                                playbackDelayed = false;
                            }
                            pausePlayback();
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                            synchronized(focusLock) {
                                resumeOnFocusGain = true;
                                playbackDelayed = false;
                            }
                            pausePlayback();
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                            // ... pausing or ducking depends on your app
                            break;
                    }
                }
            }

                //Create and setup the {@link MediaPlayer} for the audio resource associated with the current word
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, words.get(position).getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mMediaPlayer) {
                        releaseMediaPlayer();

                    }
                });
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}