package com.fluxinated.materialdetailflow.common.fragments.Examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fluxinated.materialdetailflow.common.fragments.BaseFragment;

/**
 * Created by taurus on 11/12/15.
 */
public class SampleContent extends BaseFragment
{


    public static SampleContent newInstance(@Nullable String params)
    {

        Bundle args = new Bundle();
        SampleContent fragment = new SampleContent();
        args.putString(FRAGMENT_KEY,fragment.getClass().getSimpleName());
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView mTextView = new TextView(getActivity());
        mTextView.setText(getArguments().getString(FRAGMENT_KEY));
        mTextView.setGravity(Gravity.CENTER);
        return mTextView;
    }

    @Override
    protected void initializeViews(ViewGroup vg) {

    }
}
