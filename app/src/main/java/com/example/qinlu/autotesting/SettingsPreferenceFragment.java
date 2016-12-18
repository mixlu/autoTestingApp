package com.example.qinlu.autotesting;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by qinlu on 8/14/16.
 */
public class SettingsPreferenceFragment extends PreferenceFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_settings_common, container, false);
//        if (layout != null) {
//            AppCompatPreferenceActivity activity = (AppCompatPreferenceActivity) getActivity();
//            Toolbar toolbar = (Toolbar) layout.findViewById(R.id.toolbar);
//            activity.setSupportActionBar(toolbar);
//
//            ActionBar bar = activity.getSupportActionBar();
//            bar.setHomeButtonEnabled(true);
//            bar.setDisplayHomeAsUpEnabled(true);
//            bar.setDisplayShowTitleEnabled(true);
//            bar.setTitle(getPreferenceScreen().getTitle());
//        }

        return layout;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (getView() != null) {
            View frame = (View) getView().getParent();
            if (frame != null)
                frame.setPadding(0, 0, 0, 0);
        }
    }
}
