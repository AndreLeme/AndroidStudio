package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreA;
    int scoreB;
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
     * Increases the given score for 3 points.
     */
    public void threePointsA(View v) {
        scoreA = scoreA + 3;
        displayForTeamA(scoreA);
    }

    /**
     * Increases the given score for 2 points.
     */
    public void twoPointsA(View v) {
        scoreA = scoreA + 2;
        displayForTeamA(scoreA);
    }

    /**
     * Increases the given score for 1 point.
     */
    public void freeThrowA(View v) {
        scoreA = scoreA + 1;
        displayForTeamA(scoreA);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increases the given score for 3 points.
     */
    public void threePointsB(View v) {
        scoreB = scoreB + 3;
        displayForTeamB(scoreB);

    }

    /**
     * Increases the given score for 2 points.
     */
    public void twoPointsB(View v) {
        scoreB = scoreB + 2;
        displayForTeamB(scoreB);
    }

    /**
     * Increases the given score for 1 point.
     */
    public void freeThrowB(View v) {
        scoreB = scoreB + 1;
        displayForTeamB(scoreB);
    }

    public void reset(View v) {
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }
}