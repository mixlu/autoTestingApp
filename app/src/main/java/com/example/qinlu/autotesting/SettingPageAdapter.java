package com.example.qinlu.autotesting;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinlu on 8/2/16.
 */
public class SettingPageAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;

    public SettingPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
    // See more detail on http://stackoverflow.com/questions/18413309/how-to-implement-a-viewpager-with-different-fragments-layouts
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SettingsTabFragment1 tab1 = new SettingsTabFragment1();
                return tab1;
            case 1:
                SettingsTabFragment2 tab2 = new SettingsTabFragment2();
                return tab2;
//            case 2:
//                SettingsTabFragment3 tab3 = new SettingsTabFragment3();
//                return tab3;
//            case 3:
//                SettingsTabFragment4 tab4 = new SettingsTabFragment4();
//                return tab4;
//            case 4:
//                SettingsTabFragment5 tab5 = new SettingsTabFragment5();
//                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
