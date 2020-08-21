package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for 3 points.
     */
    public void threePointsA(View v) {
        displayForTeamA(3);
    }

    /**
     * Displays the given score for 2 points.
     */
    public void twoPointsA(View v) {
        displayForTeamA(2);
    }

    /**
     * Displays the given score for 1 point.
     */
    public void freeThrowA(View v) {
        displayForTeamA(1);
    }

}