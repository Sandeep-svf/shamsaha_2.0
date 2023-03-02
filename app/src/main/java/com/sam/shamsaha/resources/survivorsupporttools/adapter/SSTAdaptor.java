package com.sam.shamsaha.resources.survivorsupporttools.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.sam.shamsaha.R;
import com.sam.shamsaha.resources.percountry.ResourcesDetails;

public class SSTAdaptor extends RecyclerView.Adapter<SSTViewHolder> {

    private Context context;

    public SSTAdaptor(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SSTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sstv_view_holder,parent,false);
        return new SSTViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SSTViewHolder holder, int position) {


        holder.ssta_item_view.setOnClickListener(new View.OnClickListener() {
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
        return 50;
    }
}
class SSTViewHolder extends RecyclerView.ViewHolder{

    CardView ssta_item_view;

    public SSTViewHolder(@NonNull View itemView) {
        super(itemView);
        ssta_item_view = itemView.findViewById(R.id.ssta_item_view);
    }
}