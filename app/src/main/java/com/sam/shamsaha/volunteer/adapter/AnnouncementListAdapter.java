package com.sam.shamsaha.volunteer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sam.shamsaha.R;

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

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
class AnnouncementListViewHolder extends RecyclerView.ViewHolder {

    public AnnouncementListViewHolder(@NonNull View itemView) {
        super(itemView);



    }
}