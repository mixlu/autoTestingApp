package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by qinlu on 8/10/16.
 * An abstract base class for all settings preference fragments.
 */
public class EntrySettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_entry);
    }

    /**
     * This fragment contains a second-level set of preference that you
     * can get to by tapping an item in the first preferences fragment.
     * 废气检验员管理 Fragment
     */
    public static class EmissionInspectorFragmentInner extends PreferenceFragment {
//        @Override
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//
//            // Can retrieve arguments from preference XML.
//            Log.i("args", "Arguments: " + getArguments());
//
//            // Load the preferences from an XML resource
////            addPreferencesFromResource(R.xml.fragmented_preferences_inner);
    }
    public static class ExteriorInspectorFragmentInner extends PreferenceFragment {
//        @Override
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//
//            // Can retrieve arguments from preference XML.
//            Log.i("args", "Arguments: " + getArguments());
//
//            // Load the preferences from an XML resource
////            addPreferencesFromResource(R.xml.fragmented_preferences_inner);
    }
    public static class CommandInspectorFragmentInner extends PreferenceFragment {
//        @Override
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//
//            // Can retrieve arguments from preference XML.
//            Log.i("args", "Arguments: " + getArguments());
//
//            // Load the preferences from an XML resource
////            addPreferencesFromResource(R.xml.fragmented_preferences_inner);
    }
    public static class MakeModelFragmentInner extends PreferenceFragment {

    }
    public static class PlatePrefixFragmentInner extends PreferenceFragment {

    }
    public static class OrgFragmentInner extends PreferenceFragment {

    }
}
