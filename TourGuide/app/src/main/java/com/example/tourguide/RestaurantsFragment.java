package com.example.tourguide;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    //Member Variables
    private RecyclerView.LayoutManager layoutManager;


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vizag, container, false);

        // ArrayList of list items
        final ArrayList<ListItem> listitems = new ArrayList<>();

        listitems.add(new ListItem(getString(R.string.secondRestaurant), R.drawable.horizons_restaurant, getString(R.string.map_url_restaurant_2),
                getString(R.string.second_restaurant_description)));
        listitems.add(new ListItem(getString(R.string.thirdRestaurant), R.drawable.the_sqaure_restaurant, getString(R.string.map_url_restaurant_3),
                getString(R.string.third_restaurant_description)));
        listitems.add(new ListItem(getString(R.string.fourthRestaurant), R.drawable.v_hotel_olive_restaurant, getString(R.string.map_url_restaurant_4),
                getString(R.string.fourth_restaurant_description)));
        listitems.add(new ListItem(getString(R.string.fifthRestaurant), R.drawable.sams_griddle, getString(R.string.map_url_restaurant_5),
                getString(R.string.fifth_restaurant_description)));
        listitems.add(new ListItem(getString(R.string.firstRestaurant), R.drawable.aroma_restaurant, getString(R.string.map_url_restaurant_1),
                getString(R.string.first_restaurant_description)));


        final RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(getContext(), listitems);

        recyclerView.setAdapter(adapter);


        return rootView;

    }

}
