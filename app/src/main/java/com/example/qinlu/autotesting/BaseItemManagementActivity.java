package com.example.qinlu.autotesting;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
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
    /**
     * 根据被调用的类的名字返回相应类
     *
     * @param  fromClass  相应类的字符床名字
     * @return      相应类
     */
    public static Class getCallerClass(String fromClass) {
        if (fromClass.contains(EmissionInspectorManagementActivity.class.getName().toString())) {
            return EmissionInspectorManagementActivity.class;
        } else if (fromClass.contains(ExteriorInspectorManagementActivity.class.getName().toString())) {
            return ExteriorInspectorManagementActivity.class;
        } else if (fromClass.contains(CommanderManagementActivity.class.getName().toString())) {
            return CommanderManagementActivity.class;
        } else if (fromClass.contains(OrgManagementActivity.class.getName().toString())) {
            return OrgManagementActivity.class;
        } else if (fromClass.contains(PlateTypeManagementActivity.class.getName().toString())) {
            return PlateTypeManagementActivity.class;
        } else if (fromClass.contains(PlatePrefixManagementActivity.class.getName().toString())) {
            return PlatePrefixManagementActivity.class;
        }
        return null;
    }

    /**
     * 这个方法调用警示弹出窗口
     * 确认用户是否真的想删除这个条目
     *
     * @param  itemName  要删除条目的名字
     * @param  id 要删除条目的id
     * @param  dbTable 相应数据库的名字
     */
    protected void showDeleteAlert(final String itemName, final long id, final String dbTable) {
        new AlertDialog.Builder(this)
                .setTitle("删除条目")
                .setMessage("确定要删除 " + itemName + " ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        inspectDbManager.deleteItemFromTable(id, dbTable);
                        finish();
                        startActivity(getIntent());
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(R.drawable.ic_warning)
                .show();
    }
}