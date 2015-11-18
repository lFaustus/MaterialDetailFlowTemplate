package com.fluxinated.materialdetailflow;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fluxinated.materialdetailflow.common.activities.BaseActivity;
import com.fluxinated.materialdetailflow.common.fragments.Examples.SampleContent;
import com.fluxinated.materialdetailflow.common.fragments.Examples.SampleTabLayout;
import com.fluxinated.materialdetailflow.common.fragments.Examples.SampleTabLayout.TabContentChange;
import com.fluxinated.materialdetailflow.navigation.NavigationDrawerCallbacks;
import com.fluxinated.materialdetailflow.navigation.NavigationDrawerFragment;


public class MainActivity extends BaseActivity
        implements NavigationDrawerCallbacks,TabContentChange
{

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);


        if (findViewById(R.id.fragment_content_container) != null)
            mTwoPane = true;
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);
        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
        // populate the navigation drawer
        mNavigationDrawerFragment.setUserData("John Doe", "johndoe@doe.com", BitmapFactory.decodeResource(getResources(), R.drawable.avatar));

    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    public boolean isTwoPane()
    {
        return mTwoPane;
    }

    @Override
    public void onNavigationDrawerItemSelected(int position,@Nullable Object obj)
    {
        // update the main content by replacing fragments
        //if(mNavigationDrawerFragment !=null && mNavigationDrawerFragment.getCurrentSelectedPosition() != position  )
        //{
            Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
            switch (position)
            {
                case 0:
                    super.FragmentTransaction(R.id.fragment_content_container, SampleContent.newInstance(null),FragmentTransition.NONE,false,null);
                    break;

                case 1:
                    break;

                case 2:
                    super.FragmentTransaction(R.id.fragment_content_container, SampleTabLayout.newInstance(),FragmentTransition.NONE,false,null);
                    break;

                case 3:

                    break;
            }
        //}
    }

    @Override
    public void onBackPressed()
    {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (!mNavigationDrawerFragment.isDrawerOpen())
        {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onTabSelected(int pos, int container)
    {
        super.FragmentTransaction(R.id.tab_layout_fragment_container, SampleTabLayout.testFragment.newInstance(String.valueOf(pos)), BaseActivity.FragmentTransition.NONE,false,null);
    }
}
