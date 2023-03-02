package com.sam.shamsaha.utility;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {


    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    private int PRIVATE_MODE = 0;

    private SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(StaticKey.PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }




}
