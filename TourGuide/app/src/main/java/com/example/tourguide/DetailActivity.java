package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle inBundle = getIntent().getExtras();

        // Place details BUNDLE from MainActivity

        final String titleOfPlace = inBundle.getString("TitleOfThePlace");
        final String descriptionOfPlace = inBundle.getString("placeDescription");
        final int imageId = inBundle.getInt("ImageOfThePlace");
        final String map_url = inBundle.getString("place_map_URL");

        //Find the Views to hold the Place info


        ImageView imageOfPlace = findViewById(R.id.detail_image);
        imageOfPlace.setImageResource(imageId);

        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        toolbar.setTitle(titleOfPlace);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView text_description = findViewById(R.id.detail_description);
        text_description.setText(descriptionOfPlace);

        //Launch maps when the map floating action button is clicked
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri mapuri = Uri.parse(map_url);
                Intent intent = new Intent(Intent.ACTION_VIEW, mapuri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });


    }
}
