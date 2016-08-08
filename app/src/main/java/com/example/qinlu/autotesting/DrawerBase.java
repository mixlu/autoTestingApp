package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.WindowCompat;
import android.support.v4.widget.DrawerLayout;

/**
 * Created by qinlu on 8/1/16.
 */
public class DrawerBase extends FragmentActivity {
    protected DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(WindowCompat.FEATURE_ACTION_BAR);
        setContentView(R.layout.page_settings);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //This is about creating custom listview for navigate drawer
        //Implementation for NavigateDrawer HERE !
//        ArrayList<DrawerListItem> drawerListItems = new ArrayList<DrawerListItem>();
//        drawerListItems.add(new DrawerListItem(0,"AIR° DEVICES"));
//        drawerListItems.add(new DrawerListItem(1,"A/C Device [1]"));
//        drawerListItems.add(new DrawerListItem(1,"A/C Device [2]"));
//        drawerListItems.add(new DrawerListItem(1,"A/C Device [3]"));
//        drawerListItems.add(new DrawerListItem(0,"AIR° FEATURES"));
//        drawerListItems.add(new DrawerListItem(2,"SLEEP MODE"));
//        drawerListItems.add(new DrawerListItem(2,"TRACKING MODE"));
//        drawerListItems.add(new DrawerListItem(2,"SETTINGS"));
//        DrawerAdapter mDrawerAdapter = new DrawerAdapter(this, R.layout.drawer_list_header, drawerListItems);
//        ListView mDrawerList = (ListView) findViewById(R.id.left_drawer);
//        mDrawerList.setAdapter(mDrawerAdapter);
    }
}
