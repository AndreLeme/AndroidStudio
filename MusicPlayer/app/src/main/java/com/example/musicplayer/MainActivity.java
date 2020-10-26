package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.dontworry);

        Button playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(view -> mediaPlayer.start());

        Button pauseButton = findViewById(R.id.pause_button);
        pauseButton.setOnClickListener(view -> mediaPlayer.pause());

        Button rewindButton = findViewById(R.id.rewind_button);
        rewindButton.setOnClickListener(view -> mediaPlayer.seekTo(0));

        mediaPlayer.setOnCompletionListener(mediaPlayer -> Toast.makeText(MainActivity.this, "I'm done!", Toast.LENGTH_SHORT).show());
    }
}