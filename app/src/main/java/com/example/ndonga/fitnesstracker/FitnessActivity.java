package com.example.ndonga.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FitnessActivity extends AppCompatActivity {
    private TextView mTracksTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);
        mTracksTextView = (TextView) findViewById(R.id.tracksTextView);
        Intent intent = getIntent();
        String track = intent.getStringExtra("track");
        mTracksTextView.setText("Welcome to" + track + " Fitness");
    }
}
