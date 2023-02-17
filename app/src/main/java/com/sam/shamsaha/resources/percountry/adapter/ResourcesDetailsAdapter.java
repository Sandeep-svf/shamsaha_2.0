package com.sam.shamsaha.resources.percountry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sam.shamsaha.R;

public class ResourcesDetailsAdapter extends RecyclerView.Adapter<ResourcesDetailsViewHolder> {


    private Context context;

    public ResourcesDetailsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ResourcesDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.resources_view_holder, parent, false);
        return  new ResourcesDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResourcesDetailsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }
}
class ResourcesDetailsViewHolder extends RecyclerView.ViewHolder {

    public ResourcesDetailsViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}