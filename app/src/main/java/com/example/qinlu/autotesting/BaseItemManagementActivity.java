package com.example.qinlu.autotesting;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by qinlu on 8/14/16.
 * 这个类是用于管理关于listview添加，删除，更新的基本类
 * 包含tolbar
 * 包含lsitview
 * 所有操作员管理，车牌管理等条目管理页面都继承此类
 */

public abstract class BaseItemManagementActivity extends AppCompatActivity {

    public ListView listView;
    TextView emptyView;
    InspectionDataBaseAdapter inspectDbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // create a instance of SQLite Database
        inspectDbManager = new InspectionDataBaseAdapter(this);
        inspectDbManager = inspectDbManager.open();

        setContentView(R.layout.fragment_emp_list);
        listView = (ListView) findViewById(R.id.list_view);
        emptyView = (TextView) findViewById(R.id.empty);
        listView.setEmptyView(emptyView);
    }
    @Override
    public void setContentView(int layoutResID){
        super.setContentView(layoutResID);
        setupToolbar();
    }

    protected void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        bar.setHomeButtonEnabled(true);
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setDisplayShowTitleEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.additem_menu, menu);
        return true;
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

    public static Class getCallerClass(String fromClass) {
        if (fromClass.contains(EmissionInspectorManagementActivity.class.getName().toString())) {
            return EmissionInspectorManagementActivity.class;
        } else if (fromClass.contains(ExteriorInspectorManagementActivity.class.getName().toString())) {
            return ExteriorInspectorManagementActivity.class;
        } else if (fromClass.contains(CommanderManagementActivity.class.getName().toString())) {
            return CommanderManagementActivity.class;
        } else if (fromClass.contains(OrgManagementActivity.class.getName().toString())) {
            return OrgManagementActivity.class;
        } else if (fromClass.contains(MakeModelManagementActivity.class.getName().toString())) {
            return MakeModelManagementActivity.class;
        } else if (fromClass.contains(PlatePrefixManagementActivity.class.getName().toString())) {
            return PlatePrefixManagementActivity.class;
        }
        return null;
    }
}