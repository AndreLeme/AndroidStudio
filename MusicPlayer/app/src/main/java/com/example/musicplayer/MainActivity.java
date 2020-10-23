package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.dontworry);

        Button playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(v -> mediaPlayer.start());

        Button pauseButton = findViewById(R.id.pause_button);
        pauseButton.setOnClickListener(v -> mediaPlayer.pause());

        Button rewindButton = findViewById(R.id.rewind_button);
        rewindButton.setOnClickListener(v -> mediaPlayer.seekTo(0));

    }
}