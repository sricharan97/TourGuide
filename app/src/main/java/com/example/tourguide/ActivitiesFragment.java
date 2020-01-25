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

public class ActivitiesFragment extends Fragment {

    private RecyclerView.LayoutManager layoutManager;


    public ActivitiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vizag, container, false);

        // ArrayList of list items
        final ArrayList<ListItem> listitems = new ArrayList<>();

        listitems.add(new ListItem(getString(R.string.firstActivity), R.drawable.ins_kurusura, getString(R.string.map_url_activity_1),
                getString(R.string.first_activity_description)));
        listitems.add(new ListItem(getString(R.string.secondActivity), R.drawable.ramakrishna_beach, getString(R.string.map_url_activity_2),
                getString(R.string.second_activity_description)));
        listitems.add(new ListItem(getString(R.string.thirdActivity), R.drawable.rushikonda_beach, getString(R.string.map_url_activity_3),
                getString(R.string.third_activity_description)));
        listitems.add(new ListItem(getString(R.string.fourthActivity), R.drawable.kailasagiri, getString(R.string.map_url_activity_4),
                getString(R.string.fourth_activity_description)));
        listitems.add(new ListItem(getString(R.string.fifthActivity), R.drawable.indira_gandhi_zoological_park,
                getString(R.string.map_url_activity_5), getString(R.string.fifth_activity_description)));
        listitems.add(new ListItem(getString(R.string.sixthActivity), R.drawable.dolphins_nose, getString(R.string.map_url_activity_6)
                , getString(R.string.sixth_activity_description)));


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
