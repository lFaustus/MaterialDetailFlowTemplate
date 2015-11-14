package com.fluxinated.materialdetailflow.common.fragments.Examples;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fluxinated.materialdetailflow.MainActivity;
import com.fluxinated.materialdetailflow.R;
import com.fluxinated.materialdetailflow.common.fragments.BaseFragment;

import static android.support.design.widget.TabLayout.OnTabSelectedListener;
import static android.support.design.widget.TabLayout.Tab;

/**
 * Created by taurus on 11/14/15.
 */
public class SampleTabLayout extends BaseFragment implements OnTabSelectedListener
{

    private TabLayout mTabLayout;
    private TabContentChange mTabContentChangeCallBack;

    public static SampleTabLayout newInstance()
    {

        Bundle args = new Bundle();
        SampleTabLayout fragment = new SampleTabLayout();
        args.putString(FRAGMENT_KEY,fragment.getClass().getSimpleName());
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_tab_using_android_design_support_lib,container,false);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try
        {
            mTabContentChangeCallBack = ((MainActivity)getActivity());
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        initializeViews((ViewGroup) getView().getRootView());
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 2"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 3"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 4"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 5"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 6"));

    }

    @Override
    protected void initializeViews(ViewGroup vg)
    {
        for(int i=0; i<vg.getChildCount();i++)
        {
            if(vg.getChildAt(i) instanceof ViewGroup)
            {
                if(vg.getChildAt(i) instanceof TabLayout)
                {
                    mTabLayout = (TabLayout) vg.getChildAt(i);
                    mTabLayout.setOnTabSelectedListener(this);
                }
                else
                    initializeViews((ViewGroup) vg.getChildAt(i));
            }
            else
            {
                ;
            }
        }
    }


    @Override
    public void onTabSelected(Tab tab)
    {

        if(mTabContentChangeCallBack != null)
        {
            mTabContentChangeCallBack.onTabSelected(tab.getPosition(),R.id.tab_layout_fragment_container);
        }
    }


    @Override
    public void onTabUnselected(Tab tab)
    {

    }

    @Override
    public void onTabReselected(Tab tab)
    {

    }


    public static class testFragment extends Fragment
    {


        public static testFragment newInstance(String params)
        {

            Bundle args = new Bundle();
            testFragment fragment = new testFragment();
            args.putString(FRAGMENT_KEY,params);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
        {
            TextView mTextView = new TextView(getActivity());
            mTextView.setText("This is fragment " + getArguments().getString(FRAGMENT_KEY));
            mTextView.setGravity(Gravity.CENTER);
            return mTextView;
        }
    }

    public interface TabContentChange
    {
        void onTabSelected(int pos,int container);
    }

}
