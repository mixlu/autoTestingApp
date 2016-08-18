package com.example.qinlu.autotesting;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.Preference;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.preference.Preference.OnPreferenceClickListener;
import android.view.LayoutInflater;
import android.webkit.WebView;

/**
 * Created by qinlu on 8/17/16.
 * 标定制动设置 fragment
 */
public class CalibrationBrakeSettingFragment extends ToolbarPreferenceFragment{
    private final String TAG = "CalibrationB";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_calib_brake);

        // 当用户点击参考值时，显示参考值表格的对话框
        Preference tableVals =  findPreference(getString(R.string.show_table));
        if (tableVals != null) {
            tableVals.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    showDialog();
                    return true;
                }
            });
        } else {
            throw new RuntimeException("tableVals is null");
        }
        Preference defaultVals = findPreference("set_default_vals");
        // TODO: Add logic for reset all the value to default
    }

    // set up dialog table
    private void showDialog() {
        WebView view = (WebView) LayoutInflater.from(this.getActivity()).inflate(R.layout.dialog_licenses, null);
        view.loadUrl("file:///android_asset/tes.html");

        final AlertDialog.Builder d = new AlertDialog.Builder(this.getActivity());
//        d.setIcon(android.R.drawable.ic_delete);
        d.setView(view);
        d.setPositiveButton("OK",null);
        d.setTitle("参考值表格");
        d.show();

    }

}
