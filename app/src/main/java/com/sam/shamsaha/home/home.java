package com.sam.shamsaha.home;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.sam.shamsaha.R;


public class home extends Fragment {


    Animation animFadeIn, animSlideIn, animSlideInTop;
    AppCompatImageView photo;
    ConstraintLayout text_container;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        intis(view);
        set_animation();

        return view;
    }

    private void intis(View view) {
        photo = view.findViewById(R.id.photo);
        text_container = view.findViewById(R.id.text_container);
    }

    private void set_animation() {
        animSlideIn = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_bottom_custom);
        animSlideInTop = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_top_custom);
        animFadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);

        photo.setAnimation(animSlideIn);
        //btnMenu.setAnimation(animSlideInTop);
        text_container.setAnimation(animFadeIn);
    }
}