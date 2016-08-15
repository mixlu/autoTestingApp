package com.example.qinlu.autotesting;

import java.util.ArrayList;

import android.app.ListActivity;
import android.util.SparseBooleanArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.preference.PreferenceFragment;;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

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
        @Override
        public final View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                                       final Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.test_fragment, container, false);

            /** Items entered by the user is stored in this ArrayList variable */
            ArrayList list = new ArrayList();

            /** Declaring an ArrayAdapter to set items to ListView */
//            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, list);
            ;
            /** Reference to the add button of the layout main.xml */
            Button btn = (Button)v.findViewById(R.id.btnAdd);

            /** Reference to the delete button of the layout main.xml */
            Button btnDel = (Button)v.findViewById(R.id.btnDel);

            /** Defining the ArrayAdapter to set items to ListView */
//            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, list);

            /** Defining a click event listener for the button "Add" */
//            OnClickListener listener = new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    EditText edit = (EditText)v.findViewById(R.id.txtItem);
//                    list.add(edit.getText().toString());
//                    edit.setText("");
//                    adapter.notifyDataSetChanged();
//                }
//            };

            /** Defining a click event listener for the button "Delete" */
//            OnClickListener listenerDel = new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    /** Getting the checked items from the listview */
//                    SparseBooleanArray checkedItemPositions = getListView().getCheckedItemPositions();
//                    int itemCount = getListView().getCount();
//
//                    for(int i=itemCount-1; i >= 0; i--){
//                        if(checkedItemPositions.get(i)){
//                            adapter.remove(list.get(i));
//                        }
//                    }
//                    checkedItemPositions.clear();
//                    adapter.notifyDataSetChanged();
//                }
//            };

            /** Setting the event listener for the add button */
//            btn.setOnClickListener(listener);
//
//            /** Setting the event listener for the delete button */
//            btnDel.setOnClickListener(listenerDel);
//
//            /** Setting the adapter to the ListView */
//            setListAdapter(adapter);
            return v;
        }
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
     * 设备选择 Fragment
     */
    public static class EquipmentFragmentInner extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.equipment_management);
        }

    }
    /**
     * 打印报告 Fragment
     */
    public static class PrintFragmentInner extends PreferenceFragment {

    }
}
