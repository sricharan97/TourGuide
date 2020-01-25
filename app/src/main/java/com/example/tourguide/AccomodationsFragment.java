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
public class AccomodationsFragment extends Fragment {

    private RecyclerView.LayoutManager layoutManager;


    public AccomodationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_vizag, container, false);

        // ArrayList of list items
        final ArrayList<ListItem> listitems = new ArrayList<>();


        listitems.add(new ListItem(getString(R.string.firstHotel), R.drawable.novotel, getString(R.string.map_url_accommodation_1),
                getString(R.string.first_accommodation_description)));
        listitems.add(new ListItem(getString(R.string.secondHotel), R.drawable.park_hotel, getString(R.string.map_url_accommodation_2),
                getString(R.string.second_accommodation_description)));
        listitems.add(new ListItem(getString(R.string.thirdHotel), R.drawable.dolphin_hotel, getString(R.string.map_url_accommodation_3),
                getString(R.string.third_accommodation_description)));
        listitems.add(new ListItem(getString(R.string.fourthHotel), R.drawable.palm_beach_hotel, getString(R.string.map_url_accommodation_4),
                getString(R.string.fourth_accommodation_description)));
        listitems.add(new ListItem(getString(R.string.fifthHotel), R.drawable.rkbeach_hotel, getString(R.string.map_url_accommodation_5),
                getString(R.string.fifth_accommodation_description)));


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
