package com.sam.shamsaha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.google.android.material.imageview.ShapeableImageView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity implements View.OnClickListener {

    Animation animFadeIn, animSlideIn, animSlideInTop;
    AppCompatImageView photo, btnMenu;
    RelativeLayout dashboard_layout, chat_now, about_shamsaha, resource, per_country,
            contact_us, survivor_support_tools, events_media, volunteer_login, lock_app,get_involved;
    ConstraintLayout text_container;
    Boolean resourcesFlag = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.menu);
        inits();
        set_animation();
        inits_menu();
        my_sliding_window();
    }

    public void my_sliding_window() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

            final Display display = getWindowManager().getDefaultDisplay();
            int screenWidth = display.getWidth();
            //int screenWidth = getScreenWidthInPixel();
            final int slidingmenuWidth = (int) (screenWidth - (screenWidth / 3.7) + 20);
            final int offset = Math.max(0, screenWidth - slidingmenuWidth);
            getSlidingMenu().setBehindOffset(offset);
            getSlidingMenu().toggle();
            getSlidingMenu().isVerticalFadingEdgeEnabled();
            getSlidingMenu().isHorizontalFadingEdgeEnabled();
            getSlidingMenu().setMode(SlidingMenu.LEFT);
            getSlidingMenu().setFadeEnabled(true);
            getSlidingMenu().setFadeDegree(0.5f);
            getSlidingMenu().setFadingEdgeLength(10);
            getSlidingMenu().setEnabled(false);

            MainActivity mainActivity = MainActivity.this;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void inits_menu() {
        volunteer_login.setOnClickListener(this::onClick);
        lock_app.setOnClickListener(this::onClick);
        btnMenu.setOnClickListener(this::onClick);
        chat_now.setOnClickListener(this::onClick);
        dashboard_layout.setOnClickListener(this::onClick);
        about_shamsaha.setOnClickListener(this::onClick);
        resource.setOnClickListener(this::onClick);
        per_country.setOnClickListener(this::onClick);
        contact_us.setOnClickListener(this::onClick);
        events_media.setOnClickListener(this::onClick);
        survivor_support_tools.setOnClickListener(this::onClick);
        get_involved.setOnClickListener(this::onClick);
    }

    private void inits() {
        photo = (AppCompatImageView) findViewById(R.id.photo);

        lock_app = (RelativeLayout) findViewById(R.id.lock_app);
        btnMenu = (AppCompatImageView) findViewById(R.id.btnMenu);
        btnMenu = (AppCompatImageView) findViewById(R.id.btnMenu);

        dashboard_layout = (RelativeLayout) findViewById(R.id.dashboard_layout);
        get_involved = (RelativeLayout) findViewById(R.id.get_involved);

        chat_now = (RelativeLayout) findViewById(R.id.chat_now);
        about_shamsaha = (RelativeLayout) findViewById(R.id.about_shamsaha);
        resource = (RelativeLayout) findViewById(R.id.resource);
        per_country = (RelativeLayout) findViewById(R.id.per_country);
        contact_us = (RelativeLayout) findViewById(R.id.contact_us);
        dashboard_layout = (RelativeLayout) findViewById(R.id.dashboard_layout);
        events_media = (RelativeLayout) findViewById(R.id.events_media);
        survivor_support_tools = (RelativeLayout) findViewById(R.id.survivor_support_tools);
        volunteer_login = (RelativeLayout) findViewById(R.id.volunteer_login);
        text_container = (ConstraintLayout) findViewById(R.id.text_container);

    }

    private void set_animation() {
        animSlideIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_bottom_custom);
        animSlideInTop = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_top_custom);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

        photo.setAnimation(animSlideIn);
        btnMenu.setAnimation(animSlideInTop);
        text_container.setAnimation(animFadeIn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMenu:
                showMenu();
                break;

            case R.id.dashboard_layout:
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.about_shamsaha:
                break;
            case R.id.get_involved:
                break;
            case R.id.resource:
                if(resourcesFlag){
                    per_country.setVisibility(View.GONE);
                    survivor_support_tools.setVisibility(View.GONE);
                    resourcesFlag = false;
                }else{
                    per_country.setVisibility(View.VISIBLE);
                    survivor_support_tools.setVisibility(View.VISIBLE);
                    resourcesFlag = true;
                }
                break;
            case R.id.per_country:
                break;
            case R.id.survivor_support_tools:
                break;
            case R.id.events_media:
                break;
            case R.id.contact_us:
                break;
            case R.id.lock_app:
                break;
            case R.id.chat_now:
                break;
            case R.id.volunteer_login:
                break;
            case R.id.terms_conditions:
                break;


        }
    }
}