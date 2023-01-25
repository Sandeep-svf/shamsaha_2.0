package com.sam.shamsaha;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.sam.shamsaha.aboutshamsaha.AboutShamsaha;
import com.sam.shamsaha.contactus.ContactUs;
import com.sam.shamsaha.getinvolved.GetInvolved;
import com.sam.shamsaha.home.home;
import com.sam.shamsaha.lockapp.LockApp;
import com.sam.shamsaha.resources.percountry.PerCountry;
import com.sam.shamsaha.utility.SplashActivity;
import com.sam.shamsaha.utility.StaticKey;
import com.sam.shamsaha.volunteer.VolunteerLogin;

import java.util.Locale;

public class MainActivity extends SlidingFragmentActivity implements View.OnClickListener {

    Animation animFadeIn, animSlideIn, animSlideInTop;
    AppCompatImageView photo, btnMenu,languageChangeLayout;
    RelativeLayout dashboard_layout, chat_now, about_shamsaha, resource, per_country,
            contact_us, survivor_support_tools, events_media, volunteer_login, lock_app,get_involved,terms_conditions;
    ConstraintLayout text_container,container;
    public static ConstraintLayout menubar_layoout;
    Boolean resourcesFlag = false;
    boolean doubleBackToExitPressedOnce = false;
    private boolean shouldLoadHomeFragOnBackPress = true;
    private static final String TAG_DASH_BOARD = "dashboard";
    public static String CURRENT_TAG = TAG_DASH_BOARD;
    private int navItemIndex;
    private static final String home = "home";

    Dialog dialog;
    private SharedPreferences sharedPreferences;
    private String languageFlag = StaticKey.languageEn;
    private AlertDialog dialogs;






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.menu);
        inits();
        set_animation();
        inits_menu();
        my_sliding_window();


        sharedPreferences= this.getSharedPreferences("LANGUAGE_NAME", Context.MODE_PRIVATE);
        String checkLanguage =sharedPreferences.getString("language","");
        Log.e("test_language","checkLanguage: "+checkLanguage);



        if(languageFlag.equals(StaticKey.languageEn)){
            Locale locale = new Locale(languageFlag);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

            Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
            startActivity(intent);

        }else if(languageFlag.equals(StaticKey.languageAr)){
            Locale locale = new Locale(languageFlag);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

            Intent intent = new Intent(getApplicationContext(),SplashActivity.class);
            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(), "Something went wrong. Please try again.", Toast.LENGTH_SHORT).show();
        }



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

            CURRENT_TAG = home;

            home home = new home();
            androidx.fragment.app.FragmentManager fragmentManager12312121212 = getSupportFragmentManager();
            ((ConstraintLayout) findViewById(R.id.container)).removeAllViews();
            androidx.fragment.app.FragmentTransaction fragmentTransaction1231212121212 = fragmentManager12312121212.beginTransaction();
            fragmentTransaction1231212121212.add(R.id.container, home, CURRENT_TAG);
            fragmentTransaction1231212121212.commit();
            getSlidingMenu().toggle();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void inits_menu() {
        volunteer_login.setOnClickListener(this::onClick);
        terms_conditions.setOnClickListener(this::onClick);
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
        languageChangeLayout.setOnClickListener(this::onClick);
    }

    private void inits() {
        photo = (AppCompatImageView) findViewById(R.id.photo);
        languageChangeLayout = (AppCompatImageView) findViewById(R.id.languageChangeLayout);
        menubar_layoout = (ConstraintLayout) findViewById(R.id.menubar_layoout);
        terms_conditions = (RelativeLayout) findViewById(R.id.terms_conditions);
        lock_app = (RelativeLayout) findViewById(R.id.lock_app);
        btnMenu = (AppCompatImageView) findViewById(R.id.btnMenu);
        btnMenu = (AppCompatImageView) findViewById(R.id.btnMenu);
        container= (ConstraintLayout) findViewById(R.id.container);
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

//        photo.setAnimation(animSlideIn);
        btnMenu.setAnimation(animSlideInTop);
  //      text_container.setAnimation(animFadeIn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMenu:
               showMenu();

                break;

            case R.id.dashboard_layout:
                navItemIndex=1;
                CURRENT_TAG = "get_involved";
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.about_shamsaha:
                navItemIndex=2;
                CURRENT_TAG = "get_involved";

                AboutShamsaha aboutShamsaha = new AboutShamsaha();
                androidx.fragment.app.FragmentManager fragmentManager123121212 = getSupportFragmentManager();
                ((ConstraintLayout) findViewById(R.id.container)).removeAllViews();
                androidx.fragment.app.FragmentTransaction fragmentTransaction123121212 = fragmentManager123121212.beginTransaction();
                fragmentTransaction123121212.add(R.id.container, aboutShamsaha, CURRENT_TAG);
                fragmentTransaction123121212.commit();
                getSlidingMenu().toggle();
                break;
            case R.id.get_involved:

                navItemIndex=3;
                CURRENT_TAG = "get_involved";

                GetInvolved getInvolved = new GetInvolved();
                androidx.fragment.app.FragmentManager fragmentManager12312121212 = getSupportFragmentManager();
                ((ConstraintLayout) findViewById(R.id.container)).removeAllViews();
                androidx.fragment.app.FragmentTransaction fragmentTransaction12312121212 = fragmentManager12312121212.beginTransaction();
                fragmentTransaction12312121212.replace(R.id.container, getInvolved, CURRENT_TAG);
                fragmentTransaction12312121212.commit();
                getSlidingMenu().toggle();
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

                navItemIndex=4;
                CURRENT_TAG = "perCountry";

                PerCountry perCountry = new PerCountry();
                androidx.fragment.app.FragmentManager fragmentManager12312 = getSupportFragmentManager();
                ((ConstraintLayout) findViewById(R.id.container)).removeAllViews();
                androidx.fragment.app.FragmentTransaction fragmentTransaction12312 = fragmentManager12312.beginTransaction();
                fragmentTransaction12312.add(R.id.container, perCountry, CURRENT_TAG);
                fragmentTransaction12312.commit();
                getSlidingMenu().toggle();
                break;
            case R.id.survivor_support_tools:
                break;
            case R.id.events_media:
                break;
            case R.id.contact_us:
                navItemIndex=6;
                CURRENT_TAG = "contactUs";
                ContactUs contactUs = new ContactUs();
                androidx.fragment.app.FragmentManager fragmentManager123 = getSupportFragmentManager();
                ((ConstraintLayout) findViewById(R.id.container)).removeAllViews();
                androidx.fragment.app.FragmentTransaction fragmentTransaction123 = fragmentManager123.beginTransaction();
                fragmentTransaction123.replace(R.id.container, contactUs, CURRENT_TAG);
                fragmentTransaction123.commit();
                getSlidingMenu().toggle();
                break;
            case R.id.lock_app:
                navItemIndex=5;
                CURRENT_TAG = "lock_app";

                LockApp lockApp = new LockApp();
                androidx.fragment.app.FragmentManager fragmentManager1231212121 = getSupportFragmentManager();
                ((ConstraintLayout) findViewById(R.id.container)).removeAllViews();
                androidx.fragment.app.FragmentTransaction fragmentTransaction1231212121 = fragmentManager1231212121.beginTransaction();
                fragmentTransaction1231212121.replace(R.id.container, lockApp, CURRENT_TAG);
                fragmentTransaction1231212121.commit();
                getSlidingMenu().toggle();
                break;
            case R.id.chat_now:

                // chat now fragment .....



                break;
            case R.id.volunteer_login:
                navItemIndex=6;
                CURRENT_TAG = "lock_app";
                VolunteerLogin volunteerLogin = new VolunteerLogin();
                androidx.fragment.app.FragmentManager fragmentManager12 = getSupportFragmentManager();
                ((ConstraintLayout) findViewById(R.id.container)).removeAllViews();
                androidx.fragment.app.FragmentTransaction fragmentTransaction12 = fragmentManager12.beginTransaction();
                fragmentTransaction12.replace(R.id.container, volunteerLogin, CURRENT_TAG);
                fragmentTransaction12.commit();
                getSlidingMenu().toggle();
                break;
            case R.id.terms_conditions:

                // need to add web view on popup...

               openDialog(MainActivity.this);
                Log.e("test_sam_terms","clicled..@@@@@###");
                navItemIndex=7;
                CURRENT_TAG = "dialog";
   /*             final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.terms);
                *//*LinearLayout noDialogLogout = dialog.findViewById(R.id.noDialogLogout);
                LinearLayout yesDialogLogout = dialog.findViewById(R.id.yesDialogLogout);*//*


                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
*/
                getSlidingMenu().toggle();

                break;

            case R.id.languageChangeLayout:

                // popup for language



                final LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                View alertLayout = inflater.inflate(R.layout.test_dialog_xml_otp, null);
                final ImageView close_dialog = alertLayout.findViewById(R.id.close_dialog);

                final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                alert.setView(alertLayout);
                alert.setCancelable(false);

                dialogs = alert.create();
                dialogs.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogs.show();
                dialogs.setCanceledOnTouchOutside(true);


                close_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialogs.dismiss();
                    }
                });



                break;


        }
    }
    @Override
    public void onBackPressed() {

        Log.e("frg_test","Calling on back pressed...");

        if (shouldLoadHomeFragOnBackPress) {

            if (navItemIndex != 0) {
                Log.e("frg_test","Calling navIndex 0");
                navItemIndex = 0;
                CURRENT_TAG = TAG_DASH_BOARD;
                loadHomeFragment();
            } else {
                Log.e("frg_test","Calling navIndex not 0");
                if (doubleBackToExitPressedOnce) {
                    super.onBackPressed();
                    return;
                }
                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

                new android.os.Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {

                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);

                return;
            }
        }

    }
    public void openDialog(Context context) {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);

        dialog.setContentView(R.layout.terms);
        ImageView i = dialog.findViewById(R.id.closeBtn2);
        ProgressBar progressBar = dialog.findViewById(R.id.progressBar6);
        WebView webView = dialog.findViewById(R.id.webViewContainer);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);

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
    private void loadHomeFragment() {
        home dasboardFragment = new home();
        androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
        ((ConstraintLayout) findViewById(R.id.container)).removeAllViews();
        androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, dasboardFragment, CURRENT_TAG);
        fragmentTransaction.commitAllowingStateLoss();
    }
}