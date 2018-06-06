package com.example.ndonga.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FitnessActivity extends AppCompatActivity {
    @BindView(R.id.tracksTextView) TextView mTracksTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);
        @ButterKnife.bind(this);
        Intent intent = getIntent();
        String track = intent.getStringExtra("track");
        mTracksTextView.setText("Welcome to" + track + " Fitness");
    }
}
