package com.example.user.complaintapp;

import android.app.Application;

import java.net.CookieHandler;
import java.net.CookieManager;

/**
 * Created by USER on 29-03-2016.
 */
public class MyApp2  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);
    }
}
