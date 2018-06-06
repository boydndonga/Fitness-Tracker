package com.example.ndonga.fitnesstracker;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private EditText mTrackFitnessInput;
    private Button mTrackFitnessButton;
    private TextView mHomeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrackFitnessInput = (EditText) findViewById(R.id.trackFitnessInput);
        mHomeTextView = (TextView) findViewById(R.id.homeTextView);
        Typeface awesomeFont = Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf");
        mHomeTextView.setTypeface(awesomeFont);
        mTrackFitnessButton = (Button) findViewById(R.id.trackFitnessButton);
            mTrackFitnessButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
//                    Toast.makeText(MainActivity.this, "flash message", Toast.LENGTH_LONG).show();
                    String track = mTrackFitnessInput.getText().toString();
                    Log.d(TAG, track);
                    Intent intent = new Intent(MainActivity.this, FitnessActivity.class);
                    intent.putExtra("track", track);
                    startActivity(intent);
                }
            });
    }
}
