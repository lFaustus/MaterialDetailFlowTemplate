package com.fluxinated.materialdetailflow;

import android.app.Application;
import android.content.Context;

import com.fluxinated.materialdetailflow.common.utils.ScreenProperties;
import com.fluxinated.materialdetailflow.common.utils.networkutils.VolleyConnection;


/**
 * Created by Fluxi on 11/4/2015.
 */
public class MyApplication extends Application {

    private static MyApplication mInstance;
    private static VolleyConnection mVolley;
    private static ScreenProperties mProperties;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mVolley = mVolley.getInstance();
        mProperties = new ScreenProperties(this);
    }

    public static MyApplication getInstance()
    {
        return mInstance;
    }

    public static Context getAppContext()
    {
        return mInstance.getApplicationContext();
    }

    public static VolleyConnection Volley()
    {
        return mVolley;
    }

    public static ScreenProperties ScreenProperties()
    {
        return mProperties;
    }
}
