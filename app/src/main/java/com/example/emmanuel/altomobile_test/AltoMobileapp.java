package com.example.emmanuel.altomobile_test;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by Emmanuel on 9/19/2016.
 */
public class AltoMobileapp extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        //Initialize FB SDK
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }
}
