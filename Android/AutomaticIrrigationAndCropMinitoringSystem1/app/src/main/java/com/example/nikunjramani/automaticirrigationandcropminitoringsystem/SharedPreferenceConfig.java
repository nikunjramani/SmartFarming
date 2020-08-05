package com.example.nikunjramani.automaticirrigationandcropminitoringsystem;

import android.content.Context;
import android.content.SharedPreferences;
public class SharedPreferenceConfig {
    static SharedPreferences sharedPreferences;
    Context ctx;

    public SharedPreferenceConfig(Context ctx) {
        this.ctx = ctx;
        sharedPreferences = ctx.getSharedPreferences(ctx.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);

    }

    public void WriteLoginStatus(boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(ctx.getResources().getString(R.string.login_status_preference), status);
        editor.commit();
    }

    public boolean ReadLoginStatus() {
        boolean status = false;
        status = sharedPreferences.getBoolean(ctx.getResources().getString(R.string.login_status_preference), false);
        return status;
    }

    public static String getcid() {
        return sharedPreferences.getString("cid", null);
    }

    public static String getemail() {
        return sharedPreferences.getString("mail", null);
    }

    public static void getcid(int cid) {
        if (cid == 0) {
            int ss = cid;
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("cid", cid);
            editor.commit();
        }
    }

    public void getEmaill(String email) {
        if (email.length() == 0) {
            String ss = email;
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("email", email);
            editor.commit();
        }
    }
}
