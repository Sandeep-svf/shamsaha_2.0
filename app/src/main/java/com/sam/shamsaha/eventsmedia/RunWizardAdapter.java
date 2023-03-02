package com.sam.shamsaha.eventsmedia;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.sam.shamsaha.R;
import com.sam.shamsaha.resources.percountry.ResourcesDetails;


import java.util.ArrayList;
import java.util.List;

public class RunWizardAdapter extends PagerAdapter  {


    Context context;
    LayoutInflater inflater;
    List<RunWizardListModel> wizardListModelList = new ArrayList<>();

    public RunWizardAdapter(Context context, List<RunWizardListModel> wizardListModelList) {
        this.context = context;
        this.wizardListModelList = wizardListModelList;
    }



    @Override
    public int getCount() {
        return wizardListModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(ConstraintLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.run_wizard_view_holder,container,false);

        final int page = position;

        Log.e("page","page no is: "+page);


        TextView tv = (TextView) view.findViewById(R.id.welcome_text_event_media);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        AppCompatButton view_event_button = view.findViewById(R.id.view_event_button);
        tv.setText(wizardListModelList.get(position).getName());
        Glide.with(context).load(wizardListModelList.get(position).getImage())
                .into(imageView);



        view_event_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // replace fragmetn form adapter
                ((FragmentActivity)view.getContext()).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new EventDetails()).addToBackStack(null)
                        .commit();

            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout)object);
    }



}


