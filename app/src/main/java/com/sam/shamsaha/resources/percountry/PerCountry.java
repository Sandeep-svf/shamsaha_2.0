package com.sam.shamsaha.resources.percountry;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.sam.shamsaha.R;


public class PerCountry extends Fragment {

    Animation animSlideIn,animFadeIn;
    RecyclerView rcv_country_list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_per_country, container, false);

        rcv_country_list = view.findViewById(R.id.rcv_country_list);
        animSlideIn = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_bottom_custom);
        animFadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        rcv_country_list.setAnimation(animSlideIn);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        rcv_country_list.setLayoutManager(linearLayoutManager);
        PerCountryAdapter perCountryAdapter = new PerCountryAdapter(getActivity());
        rcv_country_list.setAdapter(perCountryAdapter);



        return view;
    }
}