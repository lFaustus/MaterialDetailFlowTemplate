package com.fluxinated.materialdetailflow.common.fragments.Examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fluxinated.materialdetailflow.R;
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
        String s = null;
        if(params != null)
            s = params;
        args.putString(FRAGMENT_KEY,fragment.getClass().getName() + s);
        fragment.setArguments(args);
        return fragment;
    }

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
