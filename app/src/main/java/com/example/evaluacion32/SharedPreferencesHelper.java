package com.example.evaluacion32;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    private static final String PREF_NAME = "prefs";
    private static final String KEY_IS_ADMIN = "is_admin";

    public static void setAdminLoggedIn(Context context, boolean isAdmin) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_IS_ADMIN, isAdmin);
        editor.apply();
    }

    public static boolean isAdminLoggedIn(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(KEY_IS_ADMIN, false);
    }

    public static void logout(Context context) {
        setAdminLoggedIn(context, false);
    }
}

