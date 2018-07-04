package com.example.madhu.inradius;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import java.lang.reflect.Field;

public class Dashboard extends AppCompatActivity {
    private Dashboard.SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private BottomNavigationView bottomNavigation;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        mSectionsPagerAdapter = new Dashboard.SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.beginFakeDrag();
        bottomNavigation = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigation.inflateMenu(R.menu.navbar);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();
                switch (id){
                    case R.id.feedback:
                        fragmentChange(0);
                        break;
                    case R.id.discussion:
                        fragmentChange(1);
                        break;

                    case R.id.subscriptions:
                        fragmentChange(2);
                        break;
                    case R.id.profile:
                        fragmentChange(3);
                        break;
                    
                }

                return true;
            }




        });
        disableShiftMode(bottomNavigation);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.upper_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                break;
            case R.id.item2:
                break;
            case R.id.item3:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }
//    public static void disableShiftMode(BottomNavigationView bottomNavigation) {
//    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        private SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:
                    Feedback_dashboard tab1 = new Feedback_dashboard();
                    return tab1;

                case 1:
                    Discussions_dashboard tab2 = new Discussions_dashboard();
                    return tab2;

                case 2:
                    Subcriptions_dashboard tab3 = new Subcriptions_dashboard();
                    return tab3;
                case 3:
                    Profile_dashboard tab4 = new Profile_dashboard();
                    return tab4;

                default:
                return null;
            }


        }

        @Override
        public int getCount() {
            return 4;
        }
    }
    void fragmentChange(int position) {
        mViewPager.setCurrentItem(position, true);
    }
}
