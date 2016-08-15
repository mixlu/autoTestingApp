package com.example.qinlu.autotesting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by qinlu on 8/14/16.
 * This fragment contains a second-level set of preference that you
 * can get to by tapping an item in the first preferences fragment.
 * 检验员管理 base class
 */

// TODO: add toolbar
public class InspectorManagementBase extends Activity {
    public ListView listView;
    EditText editTextView;
    ArrayList<Model> ItemModelList;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test_fragment);
        listView = (ListView) findViewById(R.id.listview);
        editTextView = (EditText) findViewById(R.id.editTextView);
        ItemModelList = new ArrayList<Model>();
        customAdapter = new CustomAdapter(getApplicationContext(), ItemModelList);
//        listView.setEmptyView(findViewById(R.id.empty));
        listView.setAdapter(customAdapter);
    }
    @SuppressLint("NewApi")
    public void addValue(View v) {
        String name = editTextView.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(getApplicationContext(), "不能为空",
                    Toast.LENGTH_SHORT).show();
        } else {
            Model md = new Model(name);
            ItemModelList.add(md);
            customAdapter.notifyDataSetChanged();
            editTextView.setText("");
        }
    }
}