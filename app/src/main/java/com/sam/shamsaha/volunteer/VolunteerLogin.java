package com.sam.shamsaha.volunteer;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.sam.shamsaha.MainActivity;
import com.sam.shamsaha.R;
import com.sam.shamsaha.utility.StaticKey;


public class VolunteerLogin extends Fragment {

    AppCompatTextView amplify,your,potential;
    AppCompatImageView shamaha_logo;
    Animation animFadeIn, animSlideIn, animSlideInTop,animSlideInLeft;
    ConstraintLayout login_in_full_layout;
    FloatingActionButton floating_action_button;
    TextInputEditText email_id,password;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_volunteer_login, container, false);
        inits(view);
        set_animation();
        MainActivity.menubar_layoout.setBackgroundResource(R.color.yellow_theam);

        floating_action_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validation()){

                    // write your code here......
                    Intent intent = new Intent(getActivity(), VolunteerHomeActivity.class);
                    startActivity(intent);
                }
            }
        });



        return view;
    }

    private boolean validation() {

        if(email_id.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Please enter email address", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!email_id.getText().toString().matches(StaticKey.regexEmail)){
            Toast.makeText(getActivity(), "Please enter valid emial address", Toast.LENGTH_SHORT).show();
            return false;
        }else if(password.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Please enter password", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
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
        password = view.findViewById(R.id.password);
        email_id = view.findViewById(R.id.email_id);

        floating_action_button = view.findViewById(R.id.floating_action_button);
        amplify = view.findViewById(R.id.amplify);
        login_in_full_layout = view.findViewById(R.id.login_in_full_layout);
        your = view.findViewById(R.id.your);
        potential = view.findViewById(R.id.potential);
        shamaha_logo = view.findViewById(R.id.shamaha_logo);
    }
}