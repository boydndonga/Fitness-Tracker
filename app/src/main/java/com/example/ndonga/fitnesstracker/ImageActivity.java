package com.example.ndonga.fitnesstracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ImageActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.imagegallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CreateList> createLists = prepareData();
        ImageArrayAdapter adapter = new ImageArrayAdapter(getApplicationContext(), createLists);
        recyclerView.setAdapter(adapter);
    }
    private final String image_titles[] = {
            "Img1",
            "Img2",
            "Img3",
            "Img4",
    };

    private final Integer image_ids[] = {
            R.drawable.alexunsplash,
            R.drawable.superhero,
            R.drawable.tower,
            R.drawable.gohunsplash,
    };
}
