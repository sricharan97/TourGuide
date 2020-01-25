package com.example.tourguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    //Member variables
    private Context ctx;
    private ArrayList<ListItem> listItems;


    //Constructor

    public MyRecyclerViewAdapter(Context ct, ArrayList<ListItem> items) {
        ctx = ct;
        listItems = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.fragment_list_item, parent, false);
        ViewHolder vh = new ViewHolder(view, new ViewHolder.RecyclerViewClickListener() {
            @Override
            public void onView(View callerView, int position) {
                Intent intent = new Intent(callerView.getContext(), DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("TitleOfThePlace", listItems.get(position).getmItemTitle());
                bundle.putString("placeDescription", listItems.get(position).getmItemDescription());
                bundle.putString("place_map_URL", listItems.get(position).getMap_URL());
                bundle.putInt("ImageOfThePlace", listItems.get(position).getmImageResourceId());
                intent.putExtras(bundle);
                callerView.getContext().startActivity(intent);
            }

            @Override
            public void onImage(ImageView im_view, int position) {
                Intent intent = new Intent(im_view.getContext(), DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("TitleOfThePlace", listItems.get(position).getmItemTitle());
                bundle.putString("placeDescription", listItems.get(position).getmItemDescription());
                bundle.putString("place_map_URL", listItems.get(position).getMap_URL());
                bundle.putInt("ImageOfThePlace", listItems.get(position).getmImageResourceId());
                intent.putExtras(bundle);
                im_view.getContext().startActivity(intent);
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final ListItem currentItem = listItems.get(position);
        //Assign the values of your ArrayList to the assigned holder views
        holder.t1.setText(currentItem.getmItemTitle());
        holder.image.setImageResource(currentItem.getmImageResourceId());

    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RecyclerViewClickListener mListener;

        private TextView t1;
        private ImageView image;

        public ViewHolder(@NonNull View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            t1 = v.findViewById(R.id.list_text);
            image = v.findViewById(R.id.list_image);
            image.setOnClickListener(this);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view instanceof ImageView) {
                mListener.onImage((ImageView) view, getAdapterPosition());
            } else {
                mListener.onView(view, getAdapterPosition());
            }

        }

        public interface RecyclerViewClickListener {

            void onView(View callerView, int position);

            void onImage(ImageView im_view, int position);
        }

    }
}
