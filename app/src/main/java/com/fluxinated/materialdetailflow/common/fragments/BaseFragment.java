package com.fluxinated.materialdetailflow.common.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

import com.fluxinated.materialdetailflow.R;

/**
 * Created by Fluxi on 11/7/2015.
 */
public abstract class BaseFragment extends Fragment
{
    public static final String FRAGMENT_KEY = "FragmentKey";
    protected String TAG;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
            TAG = getArguments().getString(FRAGMENT_KEY);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    protected abstract void initializeViews(ViewGroup vg);

    protected void FragmentTransaction(int containerViewId, Fragment fragment)
    {
        getFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.animation_slide_in
                        , R.anim.animation_slide_out
                        , R.anim.animation_slide_out2
                        , R.anim.animation_slide_in2)
                .replace(containerViewId, fragment)
                .addToBackStack(null)
                .commit();
    }
}
