package com.sam.shamsaha.volunteer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.sam.shamsaha.R;

public class VolunteerHomeActivity extends SlidingFragmentActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_home);
        setBehindContentView(R.layout.menu_vol);

        inits();
        set_animation();
        inits_menu();
        my_sliding_window();




    }

    private void my_sliding_window() {

    }

    private void inits_menu() {

    }

    private void set_animation() {
        /*animSlideIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_bottom_custom);
        animSlideInTop = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_top_custom);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

//        photo.setAnimation(animSlideIn);
        btnMenu.setAnimation(animSlideInTop);
        //      text_container.setAnimation(animFadeIn);*/
    }
    private void inits() {
    }

    @Override
    public void onClick(View view) {

    }
}