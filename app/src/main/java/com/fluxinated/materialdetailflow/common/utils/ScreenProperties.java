package com.fluxinated.materialdetailflow.common.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

import java.lang.ref.WeakReference;

/**
 * Created by User on 15/10/2015.
 */
public class ScreenProperties
{
    static DisplayMetrics metrics;
    static WeakReference<Context> activity;

    public ScreenProperties(Context context)
    {
        this.activity = new WeakReference<Context>(context);
        metrics = this.activity.get().getResources().getDisplayMetrics();
    }

    public static int getActualScreenWidth()
    {
        return metrics.widthPixels;
    }

    public static int getActualScreenHeight()
    {
        return metrics.heightPixels;
    }

    public static ScreenOrientation getScreenOrientation()
    {
        switch (activity.get().getResources().getConfiguration().orientation)
        {
            case Configuration.ORIENTATION_LANDSCAPE:
                return ScreenOrientation.LANDSCAPE;
            default:
                return ScreenOrientation.PORTRAIT;
        }
    }


    public static DensityType getDensityType()
    {
        switch(metrics.densityDpi)
        {
            case DisplayMetrics.DENSITY_LOW:
                return DensityType.LOW;
            case DisplayMetrics.DENSITY_HIGH:
                return DensityType.HIGH;
            case DisplayMetrics.DENSITY_XHIGH:
                return DensityType.XHIGH;
            case DisplayMetrics.DENSITY_XXHIGH:
                return DensityType.XXHIGH;
            case DisplayMetrics.DENSITY_XXXHIGH:
                return DensityType.XXXHIGH;
            default:
                return DensityType.MEDIUM;
        }
    }

    public static ScreenSize getScreenSize()
    {
        /* This is just a note to self since I seldom forget things
         *  AND-ING TRUTH TABLE
         *  INPUT 	OUTPUT
            A 	B 	A AND B
            0 	0 	   0
            0 	1 	   0
            1 	0 	   0
            1 	1 	   1
         * 268435539 //one of tablet's screenlayout output in decimal
‭         * 0001 0000 0000 0000 0000 0000 0101 0011‬ - binary value of said screenlayout value
         *                                    1111 - //Configuration.SCREENLAYOUT_SIZE_MASK value (0x0F which is 15 in decimal)
         *                                    0011 - output is 3 which is equivalent to Configuration.SCREENLAYOUT_SIZE_LARGE
         */
        int screensize = activity.get().getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        switch(screensize)
        {
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                return ScreenSize.SMALL;

            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                return ScreenSize.NORMAL;

            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                return ScreenSize.LARGE;

            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                return ScreenSize.XLARGE;

            default:
                return ScreenSize.UNDEFINED;
        }
    }


    public enum DensityType
    {
        LOW(DisplayMetrics.DENSITY_LOW),
        MEDIUM(DisplayMetrics.DENSITY_MEDIUM),
        HIGH(DisplayMetrics.DENSITY_HIGH),
        XHIGH(DisplayMetrics.DENSITY_XHIGH),
        XXHIGH(DisplayMetrics.DENSITY_XXHIGH),
        XXXHIGH(DisplayMetrics.DENSITY_XXXHIGH);
        private int density;

        DensityType(int density_)
        {
            density = density_;
        }

        public int getDensity()
        {
            return this.density;
        }
    }

    public enum ScreenOrientation
    {
        PORTRAIT, LANDSCAPE;
    }

    public enum ScreenSize
    {
        LARGE,NORMAL,SMALL,XLARGE,UNDEFINED
    }
}