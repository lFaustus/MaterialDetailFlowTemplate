package com.fluxinated.materialdetailflow.common.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.fluxinated.materialdetailflow.R;
import com.fluxinated.materialdetailflow.common.logger.Log;
import com.fluxinated.materialdetailflow.common.logger.LogWrapper;

/**
 * Created by taurus on 11/12/15.
 */
public class BaseActivity extends AppCompatActivity
{
    public static final String TAG = "BaseActivity";
    private int FRAGMENT_ENTER_ANIM_ID;
    private int FRAGMENT_EXIT_ANIM_ID;
    private int FRAGMENT_POPENTER_ANIM_ID;
    private int FRAGMENT_POPEXIT_ANIM_ID;
    private FragmentTransaction mFragmentTransac;
    private String BACKSTACK_NAME = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initializeLogging();
    }


    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }

    /** Set up targets to receive log data */
    public void initializeLogging() {
        // Using Log, front-end to the logging chain, emulates android.util.log method signatures.
        // Wraps Android's native log framework
        LogWrapper logWrapper = new LogWrapper();
        Log.setLogNode(logWrapper);

        Log.i(TAG, "Ready");
    }

    public void initializeViews(ViewGroup v){}


    public void FragmentTransaction(int containerViewId, Fragment fragment,FragmentTransition transitionType,boolean addToBackstack,@Nullable String backstackname)
    {
        mFragmentTransac = getSupportFragmentManager().beginTransaction();
        switch (transitionType)
        {
            case CROSSFADE:
                FRAGMENT_ENTER_ANIM_ID = R.anim.animation_fade_in;
                FRAGMENT_EXIT_ANIM_ID = R.anim.animation_fade_out;
                FRAGMENT_POPENTER_ANIM_ID = R.anim.animation_fade_in;
                FRAGMENT_POPEXIT_ANIM_ID = R.anim.animation_fade_out;
                break;

            case SLIDE_IN_OUT_SIDE:
                FRAGMENT_ENTER_ANIM_ID = R.anim.animation_slide_in;
                FRAGMENT_EXIT_ANIM_ID = R.anim.animation_slide_out;
                FRAGMENT_POPENTER_ANIM_ID = R.anim.animation_slide_out2;
                FRAGMENT_POPEXIT_ANIM_ID = R.anim.animation_slide_in2;
                break;

            case NONE:
                FRAGMENT_ENTER_ANIM_ID = 0;
                FRAGMENT_EXIT_ANIM_ID = 0;
                FRAGMENT_POPENTER_ANIM_ID = 0;
                FRAGMENT_POPEXIT_ANIM_ID = 0;

                break;
        }

        mFragmentTransac.setCustomAnimations(FRAGMENT_ENTER_ANIM_ID
                , FRAGMENT_EXIT_ANIM_ID
                , FRAGMENT_POPENTER_ANIM_ID
                , FRAGMENT_POPEXIT_ANIM_ID);

        if(addToBackstack)
        {
            mFragmentTransac.addToBackStack(backstackname);
        }
        else
            mFragmentTransac.disallowAddToBackStack();


        mFragmentTransac.replace(containerViewId, fragment)
                        .commit();



    }
    public enum FragmentTransition
    {
        CROSSFADE,
        SLIDE_IN_OUT_SIDE,
        NONE
    }

}
