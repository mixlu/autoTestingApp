package com.example.qinlu.autotesting;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.content.Intent;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by qinlu on 8/5/16.
 * The activity that contains global_toolbar, global_navdrawer and snack bar fragments.
 * The activity can be shared by all the pages except setting entries pages
 *
 * The following Ids should be in every activity with exactly the same id:
 * 1. R.id.drawer_layout
 * 2. R.id.global_toolbar
 * 3. R.id.nav_view
 */

public abstract class BaseActivity extends AppCompatActivity implements OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private Toolbar mActionBarToolbar;
    protected NavigationView mNavigationView;
    private ActionBarDrawerToggle mToggle;
    private static final String TAG = "Base Activity";

    @Override
    public void setContentView(int layoutResID){
        super.setContentView(layoutResID);

        setActionBarToolbar();
        setupNavDrawer();

        // Set up Snackbar
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // TODO: Add additional logic for snackbar clicking
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    protected Toolbar setActionBarToolbar() {
        if (mActionBarToolbar == null) {
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
            if (mActionBarToolbar != null) {
                setSupportActionBar(mActionBarToolbar);
            }
        }
        return mActionBarToolbar;
    }

    private void setupNavDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        Log.v(TAG, "drawer layout found");
        if (mDrawerLayout == null) {
            Log.v(TAG, "drawer layout not found");
            return;
        }
        // Setup toggle button
        mToggle = new ActionBarDrawerToggle(BaseActivity.this, mDrawerLayout, R.string.app_name, R.string.app_name);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(this);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_faq) {
            Toast.makeText(BaseActivity.this, "还没开发", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_report) {
            Toast.makeText(BaseActivity.this, "还没开发", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_signout) {
            // TODO: Add right behaviour to logout
            Intent i = new Intent(this, WelcomeActivity.class);
            startActivity(i);
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.inspection_toolbar_menu, menu);
        return true;
    }

    // TODO: update to reasonable toolbar menu action
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.nav_settings:
                // Goto settings page
                Intent i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                return true;
            case R.id.menu_clearall:
                Toast.makeText(BaseActivity.this, "清空所有tab的信息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_save:
                Toast.makeText(BaseActivity.this, "保存信息", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}