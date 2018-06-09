package com.example.ndonga.fitnesstracker;

import android.content.Context;
import android.widget.ArrayAdapter;

public class TrackArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mFitTrack;

    public TrackArrayAdapter(Context mContext, int resource, String[] mFitTrack) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mFitTrack = mFitTrack;

    }


    @Override
    public Object getItem(int position) {
        String fitnessTrack= mFitTrack[position];
        return String.format("%s \nServes great: %s", fitnessTrack);
    }

    @Override
    public int getCount() {
        return mFitTrack.length;
    }
}