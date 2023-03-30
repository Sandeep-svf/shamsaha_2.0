package com.sam.shamsaha.volunteer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.sam.shamsaha.R;
import com.sam.shamsaha.eventsmedia.EventDetails;
import com.sam.shamsaha.volunteer.announcement.AnnouncementsDetails;

public class AnnouncementListAdapter extends RecyclerView.Adapter<AnnouncementListViewHolder> {

    private Context context;

    public AnnouncementListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AnnouncementListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.announcement_design, parent, false);
        return  new AnnouncementListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementListViewHolder holder, int position) {


        holder.item_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FragmentActivity)view.getContext()).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_vol, new AnnouncementsDetails()).addToBackStack(null)
                        .commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return 50;
    }
}
class AnnouncementListViewHolder extends RecyclerView.ViewHolder {

    CardView item_view;
    public AnnouncementListViewHolder(@NonNull View itemView) {
        super(itemView);

        item_view = itemView.findViewById(R.id.item_view);



    }
}