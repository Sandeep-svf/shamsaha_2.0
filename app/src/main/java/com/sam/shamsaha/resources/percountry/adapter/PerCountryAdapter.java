package com.sam.shamsaha.resources.percountry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.sam.shamsaha.R;
import com.sam.shamsaha.resources.percountry.ResourcesDetails;

public class PerCountryAdapter extends RecyclerView.Adapter<PerCountryViewHolder> {

    private Context context;

    public PerCountryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PerCountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.per_country_xml, parent, false);
        return  new PerCountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PerCountryViewHolder holder, int position) {

        holder.item_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // replace fragment

                ((FragmentActivity)view.getContext()).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new ResourcesDetails()).addToBackStack(null)
                        .commit();

            }
        });

    }



    @Override
    public int getItemCount() {
        return 10;
    }
}
class PerCountryViewHolder extends RecyclerView.ViewHolder {

    CardView item_view;

    public PerCountryViewHolder(@NonNull View itemView) {
        super(itemView);
        item_view = itemView.findViewById(R.id.item_view);
    }
}