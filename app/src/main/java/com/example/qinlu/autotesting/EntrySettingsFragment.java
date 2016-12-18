package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by qinlu on 8/10/16.
 * 录入设置 fragments.
 */
public class EntrySettingsFragment extends SettingsPreferenceFragment {
    private static final String TAG = "EntrySettingsFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_entry);
    }

    /**
     * 外检员管理 Fragment
     */
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
    /**
     * 引车员管理 Fragment
     */
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
    /**
     * 厂牌型号 Fragment
     */
    public static class MakeModelFragmentInner extends PreferenceFragment {

    }
    /**
     * 车牌号码前缀 Fragment
     */
    public static class PlatePrefixFragmentInner extends PreferenceFragment {

    }
    /**
     * 检测单位 Fragment
     */
    public static class OrgFragmentInner extends PreferenceFragment {

    }
    /**
     * 选择已有设备 Fragment
     */
    public static class EquipmentFragmentInner extends SettingsPreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.equipment_management);
        }

    }
    /**
     * 选择打印报告 Fragment
     */
    public static class PrintFragmentInner extends PreferenceFragment {

    }
}
