package com.example.ndonga.fitnesstracker;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
//    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.trackFitnessInput) EditText mTrackFitnessInput;
    @BindView(R.id.trackFitnessButton) Button mTrackFitnessButton;
    @BindView(R.id.homeTextView) TextView mHomeTextView;
    @BindView(R.id.mainListView) ListView mMainListView;
     String[] fitTracks = new String[] {"Physical", "Educational", "Social", "Mentorship"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mTrackFitnessInput = (EditText) findViewById(R.id.trackFitnessInput);
//        mMainListView = (ListView) findViewById(R.id.mainListView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fitTracks);
        mMainListView.setAdapter(adapter);
        mMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String track = ((TextView)view).getText().toString();
                Toast.makeText(MainActivity.this, track, Toast.LENGTH_LONG).show();
            }
        });

//        mHomeTextView = (TextView) findViewById(R.id.homeTextView);
        Typeface awesomeFont = Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf");
        mHomeTextView.setTypeface(awesomeFont);

//        mTrackFitnessButton = (Button) findViewById(R.id.trackFitnessButton);
        mTrackFitnessButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                    Toast.makeText(MainActivity.this, "flash message", Toast.LENGTH_LONG).show();
                String track = mTrackFitnessInput.getText().toString();
//                Log.d(TAG, track);
                Intent intent = new Intent(MainActivity.this, FitnessActivity.class);
                intent.putExtra("track", track);
                startActivity(intent);
            }
        });
    }
}
