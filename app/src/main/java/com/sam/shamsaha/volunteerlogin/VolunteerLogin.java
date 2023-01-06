package com.sam.shamsaha.volunteerlogin;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.sam.shamsaha.MainActivity;
import com.sam.shamsaha.R;


public class VolunteerLogin extends Fragment {

    AppCompatTextView amplify,your,potential;
    AppCompatImageView shamaha_logo;
    Animation animFadeIn, animSlideIn, animSlideInTop,animSlideInLeft;
    ConstraintLayout login_in_full_layout;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_volunteer_login, container, false);
        inits(view);
        set_animation();
        MainActivity.menubar_layoout.setBackgroundResource(R.color.yellow_theam);



        return view;
    }

    private void set_animation() {

            animSlideIn = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_bottom_custom);
            animSlideInLeft = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_left);
        animSlideInTop = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_bottom_custom);

            amplify.setAnimation(animSlideInLeft);
            your.setAnimation(animSlideInLeft);
            potential.setAnimation(animSlideInLeft);
            shamaha_logo.setAnimation(animSlideInLeft);
            login_in_full_layout.setAnimation(animSlideInTop);
           // btnMenu.setAnimation(animSlideInTop);
           // text_container.setAnimation(animFadeIn);
        }

    private void inits(View view) {
        amplify = view.findViewById(R.id.amplify);
        login_in_full_layout = view.findViewById(R.id.login_in_full_layout);
        your = view.findViewById(R.id.your);
        potential = view.findViewById(R.id.potential);
        shamaha_logo = view.findViewById(R.id.shamaha_logo);
    }
}