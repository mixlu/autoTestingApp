package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.preference.Preference;

/**
 * Created by qinlu on 8/17/16.
 */
public class ModuleSettingFragment extends ToolbarPreferenceFragment {
    private final String TAG = "ModuleSetting";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_module);

        Preference defaultVals = findPreference("set_default_vals");
        // TODO: Add logic for reset all the value to default
    }
}
