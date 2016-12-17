package com.example.qinlu.autotesting;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinlu on 8/2/16.
 */
public class InspectPageAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;

    public InspectPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                InspectTabFragment1 tab1 = new InspectTabFragment1();
                return tab1;
            case 1:
                InspectTabFragment2 tab2 = new InspectTabFragment2();
                return tab2;
            case 2:
                InspectTabFragment3 tab3 = new InspectTabFragment3();
                return tab3;
            case 3:
                InspectTabFragment4 tab4 = new InspectTabFragment4();
                return tab4;
            case 4:
                InspectTabFragment5 tab5 = new InspectTabFragment5();
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
