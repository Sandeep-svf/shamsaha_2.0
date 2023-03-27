package com.sam.shamsaha.volunteer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.sam.shamsaha.MainActivity;
import com.sam.shamsaha.R;
import com.sam.shamsaha.eventsmedia.EventMedia;
import com.sam.shamsaha.home.home;
import com.sam.shamsaha.utility.StaticKey;
import com.sam.shamsaha.volunteer.casereport.CaseReport;
import com.sam.shamsaha.volunteer.dashboard.Vol_Home;
import com.sam.shamsaha.volunteer.inpersonbackup.InPersonBackup;
import com.sam.shamsaha.volunteer.myshift.MyShift;
import com.sam.shamsaha.volunteer.resources.VolResourcesFragment;
import com.sam.shamsaha.volunteer.resources.VolResourcesKotlin;
import com.sam.shamsaha.volunteer.swiftswaprequest.SwiftSwapRequest;
import com.sam.shamsaha.volunteer.volcalendar.VolCalendar;

public class VolunteerHomeActivity extends SlidingFragmentActivity implements View.OnClickListener {

    RelativeLayout dashboard_layout_vol, my_profile_layout_vol, my_shift_layout_vol, vol_calander_layout_vol, swift_swap_layout_vol,
            on_duity_backup_layout_vol, client_service_layout_vol,language_backup_layout_vol, inperson_backup_layout_vol, provide_backup_layout_vol, case_report_layout_vol, resourse_layout_vol, event_media_layout, logout_layout, setting_layout;

    AppCompatImageView btnMenu;
    private static final String TAG_DASH_BOARD = "dashboard";
    public static String CURRENT_TAG = TAG_DASH_BOARD;
    private int navItemIndex;
    private static final String home = "home";
    ConstraintLayout container_vol;
    Dialog dialog;

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
            FragmentManager fragmentManager = getSupportFragmentManager();
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
        client_service_layout_vol = (RelativeLayout) findViewById(R.id.client_service_layout_vol);
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
        client_service_layout_vol.setOnClickListener(this::onClick);
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





            case R.id.logout_layout:
                Intent intent = new Intent(VolunteerHomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.dashboard_layout_vol:
                navItemIndex=1;
                CURRENT_TAG = "get_involved";
                Intent intent24 = new Intent(VolunteerHomeActivity.this, VolunteerHomeActivity.class);
                startActivity(intent24);
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


            case R.id.my_shift_layout_vol:
                MyShift myShift = new MyShift();
                replace_fragment(myShift);

                break;

            case R.id.client_service_layout_vol:

                openDialog(VolunteerHomeActivity.this);
                break;



            case R.id.setting_layout:


                openDialogSettings(VolunteerHomeActivity.this);

                break;

            case R.id.swift_swap_layout_vol:
                SwiftSwapRequest swiftSwapRequest = new SwiftSwapRequest();
                replace_fragment(swiftSwapRequest);
                break;

            case R.id.vol_calander_layout_vol:
                VolCalendar volCalendar = new VolCalendar();
                replace_fragment(volCalendar);
                break;

            case R.id.provide_backup_layout_vol:
                InPersonBackup inPersonBackup = new InPersonBackup();
                replace_fragment(inPersonBackup);
                break;

            case R.id.language_backup_layout_vol:
                // popup
                openDialog(VolunteerHomeActivity.this,"1");
                break;
            case R.id.inperson_backup_layout_vol:
                openDialog(VolunteerHomeActivity.this,"2");
                break;
            case R.id.my_profile_layout_vol:
                Vol_Profile vol_profile = new Vol_Profile();
                replace_fragment(vol_profile);
                break;


            case R.id.resourse_layout_vol:
                VolResourcesFragment volResourcesKotlin = new VolResourcesFragment();
                replace_fragment(volResourcesKotlin);
                break;

            case R.id.event_media_layout:
                EventMedia eventMedia = new EventMedia(StaticKey.VOLUNTEER_FLAG);
                replace_fragment(eventMedia);
                break;


            case R.id.case_report_layout_vol:
                CaseReport caseReport = new CaseReport();
                replace_fragment(caseReport);
                break;


        }
    }
    private void replace_fragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ((ConstraintLayout) findViewById(R.id.container_vol)).removeAllViews();
        androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_vol, fragment, CURRENT_TAG);
        fragmentTransaction.commit();
        getSlidingMenu().toggle();
    }
    public void openDialog(Context context, String type) {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);

        if(type.equals("1")) dialog.setContentView(R.layout.terms2);
        else  dialog.setContentView(R.layout.terms2backup);
        ImageView i = dialog.findViewById(R.id.closeBtn2);
        ProgressBar progressBar = dialog.findViewById(R.id.progressBar6);
        /*WebView webView = dialog.findViewById(R.id.webViewContainer);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);*/

        //   hitApi(context,webView,progressBar);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().getAttributes().windowAnimations = R.anim.fade_in;
    }
    public void openDialog(Context context) {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.terms3);

        ImageView i = dialog.findViewById(R.id.closeBtn2);
        AppCompatSpinner spin_case_id_list = dialog.findViewById(R.id.spin_case_id_list);
        ProgressBar progressBar = dialog.findViewById(R.id.progressBar6);
        /*WebView webView = dialog.findViewById(R.id.webViewContainer);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);*/

        // spin
        String[] items = new String[]{ "CI00109", "CI00110", "CI00106", "CI00105", "CI00104"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spin_case_id_list.setAdapter(adapter);

        //   hitApi(context,webView,progressBar);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().getAttributes().windowAnimations = R.anim.fade_in;
    }
    public void openDialogSettings(Context context) {
        Toast.makeText(VolunteerHomeActivity.this, "Clicked...", Toast.LENGTH_SHORT).show();

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.vol_settings_layout);

        ImageView i = dialog.findViewById(R.id.closeBtn2);
        AppCompatTextView changePassword = dialog.findViewById(R.id.jhsdfadhsfha);
        SwitchCompat toggle_biometric = dialog.findViewById(R.id.toggle_biometric);



        toggle_biometric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(VolunteerHomeActivity.this,ChangePasswordActivity.class);
                startActivity(intent2);
            }
        });



        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().getAttributes().windowAnimations = R.anim.fade_in;
    }
}