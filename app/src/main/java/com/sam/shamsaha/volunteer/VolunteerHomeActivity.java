package com.sam.shamsaha.volunteer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.sam.shamsaha.MainActivity;
import com.sam.shamsaha.R;
import com.sam.shamsaha.home.home;
import com.sam.shamsaha.volunteer.dashboard.Vol_Home;
import com.sam.shamsaha.volunteer.resources.VolResourcesFragment;
import com.sam.shamsaha.volunteer.resources.VolResourcesKotlin;

public class VolunteerHomeActivity extends SlidingFragmentActivity implements View.OnClickListener {

    RelativeLayout dashboard_layout_vol, my_profile_layout_vol, my_shift_layout_vol, vol_calander_layout_vol, swift_swap_layout_vol,
            on_duity_backup_layout_vol, language_backup_layout_vol, inperson_backup_layout_vol, provide_backup_layout_vol, case_report_layout_vol, resourse_layout_vol, event_media_layout, logout_layout, setting_layout;

    AppCompatImageView btnMenu;
    private static final String TAG_DASH_BOARD = "dashboard";
    public static String CURRENT_TAG = TAG_DASH_BOARD;
    private int navItemIndex;
    private static final String home = "home";
    ConstraintLayout container_vol;

    private Boolean languageBackupFlag = true;


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

            VolunteerHomeActivity volunteerHomeActivity = VolunteerHomeActivity.this;
            CURRENT_TAG = home;
            Vol_Home home = new Vol_Home();
            androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
            ((ConstraintLayout) findViewById(R.id.container_vol)).removeAllViews();
            androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container_vol, home, CURRENT_TAG);
            fragmentTransaction.commit();
            getSlidingMenu().toggle();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void inits() {

        btnMenu = (AppCompatImageView) findViewById(R.id.btnMenu);
        my_profile_layout_vol = (RelativeLayout) findViewById(R.id.my_profile_layout_vol);
        my_shift_layout_vol = (RelativeLayout) findViewById(R.id.my_shift_layout_vol);
        dashboard_layout_vol = (RelativeLayout) findViewById(R.id.dashboard_layout_vol);
        vol_calander_layout_vol = (RelativeLayout) findViewById(R.id.vol_calander_layout_vol);
        swift_swap_layout_vol = (RelativeLayout) findViewById(R.id.swift_swap_layout_vol);
        on_duity_backup_layout_vol = (RelativeLayout) findViewById(R.id.on_duity_backup_layout_vol);
        language_backup_layout_vol = (RelativeLayout) findViewById(R.id.language_backup_layout_vol);
        inperson_backup_layout_vol = (RelativeLayout) findViewById(R.id.inperson_backup_layout_vol);
        provide_backup_layout_vol = (RelativeLayout) findViewById(R.id.provide_backup_layout_vol);
        dashboard_layout_vol = (RelativeLayout) findViewById(R.id.dashboard_layout_vol);
        case_report_layout_vol = (RelativeLayout) findViewById(R.id.case_report_layout_vol);
        resourse_layout_vol = (RelativeLayout) findViewById(R.id.resourse_layout_vol);
        event_media_layout = (RelativeLayout) findViewById(R.id.event_media_layout);
        logout_layout = (RelativeLayout) findViewById(R.id.logout_layout);
        setting_layout = (RelativeLayout) findViewById(R.id.setting_layout);
        container_vol = (ConstraintLayout) findViewById(R.id.container_vol);
    }


    private void set_animation() {
        /*animSlideIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_bottom_custom);
        animSlideInTop = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_top_custom);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

//        photo.setAnimation(animSlideIn);
        btnMenu.setAnimation(animSlideInTop);
        //      text_container.setAnimation(animFadeIn);*/
    }

    private void inits_menu() {

        btnMenu.setOnClickListener(this::onClick);
        dashboard_layout_vol.setOnClickListener(this::onClick);
        my_profile_layout_vol.setOnClickListener(this::onClick);
        my_shift_layout_vol.setOnClickListener(this::onClick);
        vol_calander_layout_vol.setOnClickListener(this::onClick);
        dashboard_layout_vol.setOnClickListener(this::onClick);
        swift_swap_layout_vol.setOnClickListener(this::onClick);
        on_duity_backup_layout_vol.setOnClickListener(this::onClick);
        language_backup_layout_vol.setOnClickListener(this::onClick);
        inperson_backup_layout_vol.setOnClickListener(this::onClick);
        provide_backup_layout_vol.setOnClickListener(this::onClick);
        case_report_layout_vol.setOnClickListener(this::onClick);
        resourse_layout_vol.setOnClickListener(this::onClick);
        event_media_layout.setOnClickListener(this::onClick);
        logout_layout.setOnClickListener(this::onClick);
        setting_layout.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnMenu:
                showMenu();

                break;


            case R.id.dashboard_layout_vol:
                navItemIndex=1;
                CURRENT_TAG = "get_involved";
                Intent intent = new Intent(VolunteerHomeActivity.this, VolunteerHomeActivity.class);
                startActivity(intent);
                break;
            case R.id.on_duity_backup_layout_vol:

                Toast.makeText(VolunteerHomeActivity.this, "Called...", Toast.LENGTH_SHORT).show();

                if(languageBackupFlag){
                    languageBackupFlag = false;
                    language_backup_layout_vol.setVisibility(View.VISIBLE);
                    inperson_backup_layout_vol.setVisibility(View.VISIBLE);
                }else{
                    languageBackupFlag = true;
                    language_backup_layout_vol.setVisibility(View.GONE);
                    inperson_backup_layout_vol.setVisibility(View.GONE);
                }
                break;

            case R.id.my_profile_layout_vol:


                Vol_Profile vol_profile = new Vol_Profile();
                FragmentManager fragmentManager12312121212 = getSupportFragmentManager();
                ((ConstraintLayout) findViewById(R.id.container_vol)).removeAllViews();
                FragmentTransaction fragmentTransaction12312121212 = fragmentManager12312121212.beginTransaction();
                fragmentTransaction12312121212.replace(R.id.container_vol, vol_profile, CURRENT_TAG);
                fragmentTransaction12312121212.commit();
                getSlidingMenu().toggle();


                break;



            case R.id.resourse_layout_vol:

                VolResourcesFragment volResourcesKotlin = new VolResourcesFragment();

                FragmentManager fragmentManagerVolResources = getSupportFragmentManager();
                ((ConstraintLayout) findViewById(R.id.container_vol)).removeAllViews();
                FragmentTransaction fragmentTransactionVolResources = fragmentManagerVolResources.beginTransaction();
                fragmentTransactionVolResources.replace(R.id.container_vol,volResourcesKotlin,CURRENT_TAG);
                fragmentTransactionVolResources.commit();
                getSlidingMenu().toggle();




                break;


        }
    }
}