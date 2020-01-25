package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class VizagActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vizag);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewpager);

        /*CollapsingToolbarLayout collapsingToolbar =
              findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Visakhapatnam");*/


        // Create an adapter that knows which fragment should be shown on each page
        ModifiedFragmentAdapter adapter = new ModifiedFragmentAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        // Give the tabs an icon
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_local_activity);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_local_hotel);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_restaurant);


    }
}
