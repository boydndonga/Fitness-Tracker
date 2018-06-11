package com.example.ndonga.fitnesstracker;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener {
    @BindView(R.id.trackFitnessInput) EditText mTrackFitnessInput;
    @BindView(R.id.trackFitnessButton) Button mTrackFitnessButton;
    @BindView(R.id.homeTextView) TextView mHomeTextView;
    @BindView(R.id.mainListView) ListView mMainListView;
     String[] fitTracks = new String[] {"Physical", "Educational", "Social", "Mentorship"};
    GridView gridView;
    String[] letters = new String[] {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        TrackArrayAdapter adapter = new TrackArrayAdapter(this, android.R.layout.simple_list_item_1, fitTracks);
        mMainListView.setAdapter(adapter);
        mMainListView.setOnItemClickListener(this);

        Typeface awesomeFont = Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf");
        mHomeTextView.setTypeface(awesomeFont);

        mTrackFitnessButton.setOnClickListener(this);

        gridView = (GridView) findViewById(R.id.baseGridView);
        gridView.setAdapter(new AlphabetAdapter(this, letters));

        FragmentManager fm = getFragmentManager();
        MoodDialogFragment moodDialogFragment = new MoodDialogFragment ();
        moodDialogFragment.show(fm, "Sample Fragment");

    }
    @Override
    public void onClick(View v){
        if( v == mTrackFitnessButton) {
            String track = mTrackFitnessInput.getText().toString();
            Intent intent = new Intent(MainActivity.this, FitnessActivity.class);
            intent.putExtra("track", track);
            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String track = ((TextView)view).getText().toString();
        Toast.makeText(MainActivity.this, track, Toast.LENGTH_LONG).show();
    }
}
