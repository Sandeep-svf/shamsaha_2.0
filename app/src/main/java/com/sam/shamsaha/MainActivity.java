package com.sam.shamsaha;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

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
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.sam.shamsaha.aboutshamsaha.AboutShamsaha;
import com.sam.shamsaha.contactus.ContactUs;
import com.sam.shamsaha.eventsmedia.EventMedia;
import com.sam.shamsaha.getinvolved.GetInvolved;
import com.sam.shamsaha.home.home;
import com.sam.shamsaha.lockapp.LockApp;
import com.sam.shamsaha.resources.percountry.PerCountry;
import com.sam.shamsaha.resources.survivorsupporttools.SurvivoursSupportTools;
import com.sam.shamsaha.utility.Splash2Activity;
import com.sam.shamsaha.utility.SplashActivity;
import com.sam.shamsaha.utility.StaticKey;
import com.sam.shamsaha.volunteer.VolunteerLogin;

import java.util.Locale;

public class MainActivity extends SlidingFragmentActivity implements View.OnClickListener {

    Animation animFadeIn, animSlideIn, animSlideInTop;
    MainActivity mainActivity;
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

        sharedPreferences= this.getSharedPreferences("LANGUAGE_NAME", Context.MODE_PRIVATE);
        StaticKey.appLanguage =sharedPreferences.getString("language","");
        Log.e("test_language","checkLanguage: "+StaticKey.appLanguage);


        if(StaticKey.appLanguage.equals(StaticKey.languageEn)){
            Log.e("test_sam_lang","en");
            Locale locale = new Locale(StaticKey.appLanguage);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());



        }else if(StaticKey.appLanguage.equals(StaticKey.languageAr)){
            Log.e("test_sam_lang","ar");
            Locale locale = new Locale(StaticKey.appLanguage);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());


        }else{
            Log.e("test_sam_lang","else en");
            Locale locale = new Locale(StaticKey.languageEn);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

            // Toast.makeText(getApplicationContext(), "Something went wrong. Please try again.", Toast.LENGTH_SHORT).show();
        }


        LoadLanguage();


        if(StaticKey.appLanguage.equals(StaticKey.languageEn)){
            my_sliding_window();
        }else if(StaticKey.appLanguage.equals(StaticKey.languageAr)){
            my_sliding_window_arabic();
        }else{
            Toast.makeText(MainActivity.this, "something went wrong while loading language... Please restart app.", Toast.LENGTH_SHORT).show();
        }


    }

    private void my_sliding_window_arabic() {
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
            getSlidingMenu().setMode(SlidingMenu.RIGHT);
            getSlidingMenu().setFadeEnabled(true);
            getSlidingMenu().setFadeDegree(0.5f);
            getSlidingMenu().setFadingEdgeLength(10);
            getSlidingMenu().setEnabled(false);
            int width = display.getWidth(); // deprecated
            int height = display.getHeight();
            mainActivity = MainActivity.this;


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

    public void LoadLanguage(){

        Locale locale = new Locale(StaticKey.appLanguage);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
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
                replace_fragment(aboutShamsaha);
                break;
            case R.id.get_involved:

                navItemIndex=3;
                CURRENT_TAG = "get_involved";

                GetInvolved getInvolved = new GetInvolved();
                replace_fragment(getInvolved);
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
                replace_fragment(perCountry);
                break;
            case R.id.survivor_support_tools:
                SurvivoursSupportTools survivoursSupportTools = new SurvivoursSupportTools();
                replace_fragment(survivoursSupportTools);
                break;
            case R.id.events_media:
                EventMedia eventMedia = new EventMedia();
                replace_fragment(eventMedia);
                break;
            case R.id.contact_us:
                navItemIndex=6;
                CURRENT_TAG = "contactUs";
                ContactUs contactUs = new ContactUs();
                replace_fragment(contactUs);
                break;
            case R.id.lock_app:
                navItemIndex=5;
                CURRENT_TAG = "lock_app";

                LockApp lockApp = new LockApp();
                replace_fragment(lockApp);
                break;
            case R.id.chat_now:

                // chat now fragment .....



                break;
            case R.id.volunteer_login:
                navItemIndex=6;
                CURRENT_TAG = "lock_app";
                VolunteerLogin volunteerLogin = new VolunteerLogin();
                replace_fragment(volunteerLogin);
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
                final RadioButton english_lang_button = alertLayout.findViewById(R.id.english_lang_button);
                final RadioButton arbic_lang_button = alertLayout.findViewById(R.id.arbic_lang_button);
                final AppCompatButton language_change_button = alertLayout.findViewById(R.id.language_change_button);

                final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                alert.setView(alertLayout);
                alert.setCancelable(false);

                dialogs = alert.create();
                dialogs.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogs.show();
                dialogs.setCanceledOnTouchOutside(true);


                english_lang_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        english_lang_button.setChecked(true);
                        arbic_lang_button.setChecked(false);
                        StaticKey.appLanguage = StaticKey.languageEn;
                    }
                });

                arbic_lang_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        english_lang_button.setChecked(false);
                        arbic_lang_button.setChecked(true);
                        StaticKey.appLanguage = StaticKey.languageAr;
                    }
                });

                language_change_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        sharedPreferences = MainActivity.this.getSharedPreferences("LANGUAGE_NAME", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("language", StaticKey.appLanguage);
                        editor.apply();

                        Intent langIntent = new Intent(MainActivity.this, Splash2Activity.class);
                        startActivity(langIntent);

                    }
                });

                close_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialogs.dismiss();
                    }
                });



                break;


        }
    }

    private void replace_fragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ((ConstraintLayout) findViewById(R.id.container)).removeAllViews();
        androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragment, CURRENT_TAG);
        fragmentTransaction.commit();
        getSlidingMenu().toggle();
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