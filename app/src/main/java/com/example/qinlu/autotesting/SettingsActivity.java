package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBar;

import java.util.List;

/**
 * Created by qinlu on 7/29/16.
 * Activity for page_systemSetting screen
 */

// TODO: add toolbar
public class SettingsActivity extends AppCompatPreferenceActivity {

    @Override
    protected boolean isValidFragment(String fragmentName) {
        System.out.println(fragmentName);
        return true;
    }

    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.settings_nav, target);

        setContentView(R.layout.page_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar();
        bar.setHomeButtonEnabled(true);
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setDisplayShowTitleEnabled(true);
//        bar.setHomeAsUpIndicator(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        bar.setTitle("设置");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}