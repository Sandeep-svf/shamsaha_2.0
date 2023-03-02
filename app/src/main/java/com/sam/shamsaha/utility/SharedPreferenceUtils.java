package com.sam.shamsaha.utility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Global SharedPreferences for the app
 * in order to save user session.
 */

public class SharedPreferenceUtils {

    private static SharedPreferences sharedPreferences;


    private SharedPreferenceUtils(){

    }

    public static void init(Context context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
        }

    }


    public static void writeToSharedPreferences(String key, String value){
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }


    public static void clearSharedPreferences(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public static String readFromSharedPreferences(String key){
        return sharedPreferences.getString(key, null);
    }

    // write for get set method for particular stuff...

    public static void saveUserId(String userId){
        sharedPreferences.edit().putString(StaticKey.userId,userId).apply();
    }

    public static String getUserId(){
        return readFromSharedPreferences(StaticKey.userId);
    }

    public static void saveAuthToken(String auth){
        sharedPreferences.edit().putString(StaticKey.auth,auth);
    }

    public static String getAuthToken(){
        return readFromSharedPreferences(StaticKey.auth);
    }

}
