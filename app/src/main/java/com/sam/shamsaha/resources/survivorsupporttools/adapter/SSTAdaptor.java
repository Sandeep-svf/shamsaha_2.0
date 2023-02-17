package com.sam.shamsaha.resources.survivorsupporttools.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SSTAdaptor extends RecyclerView.Adapter<SSTViewHolder> {
    @NonNull
    @Override
    public SSTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SSTViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
class SSTViewHolder extends RecyclerView.ViewHolder{

    public SSTViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}