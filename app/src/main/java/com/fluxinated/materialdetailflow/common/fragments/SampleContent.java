package com.fluxinated.materialdetailflow.common.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fluxinated.materialdetailflow.R;

/**
 * Created by taurus on 11/12/15.
 */
public class SampleContent extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_content,container,false);
        ((TextView)v.findViewById(R.id.fragment_sample_content)).setText(TAG);
        return v;
    }

    @Override
    protected void initializeViews(ViewGroup vg) {

    }
}
