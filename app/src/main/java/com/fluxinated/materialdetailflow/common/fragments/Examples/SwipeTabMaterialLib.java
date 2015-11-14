package com.fluxinated.materialdetailflow.common.fragments.Examples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fluxinated.materialdetailflow.R;
import com.fluxinated.materialdetailflow.common.fragments.BaseFragment;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

/**
 * Created by taurus on 11/13/15.
 */
public class SwipeTabMaterialLib extends BaseFragment implements MaterialTabListener
{
    private MaterialTabHost mMaterialTabHost;
    private ViewPager mViewPager;

    public static SwipeTabMaterialLib newInstance()
    {

        Bundle args = new Bundle();
        SwipeTabMaterialLib fragment = new SwipeTabMaterialLib();
        args.putString(FRAGMENT_KEY,fragment.getClass().getSimpleName());
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_tab_using_material_tab_library,container,false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        //initializeViews((ViewGroup)getView().getRootView());

        mMaterialTabHost = (MaterialTabHost)getView().findViewById(R.id.materialTabHost);
        mViewPager = (ViewPager)getView().findViewById(R.id.viewPager);
        ViewPagerAdapter mAdapter = new ViewPagerAdapter(getFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                mMaterialTabHost.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });

        for(int i=0; i < mAdapter.getCount(); i++)
        {
            mMaterialTabHost.addTab(mMaterialTabHost.createTabText("TabText" + i)
                    .setText("Tab " + i)
                    .setTabListener(this));
        }

    }

    @Override
    protected void initializeViews(ViewGroup vg)
    {

    }

    @Override
    public void onTabSelected(MaterialTab materialTab)
    {
        mViewPager.setCurrentItem(materialTab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab materialTab)
    {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab)
    {

    }




    private class ViewPagerAdapter extends FragmentStatePagerAdapter
    {

        public ViewPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            //TODO
            return SampleContent.newInstance(position+"");
        }

        @Override
        public int getCount()
        {
            //TODO
            return 3;
        }
    }
}
