package com.example.qinlu.autotesting;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by qinlu on 9/5/2016.
 */
public class OrgManagementActivity  extends BaseItemManagementActivity {
    private SimpleCursorAdapter adapter;
    final String[] from = new String[] { "_id", "ORGNAME" };
    final int[] to = new int[] { R.id.id, R.id.itemName };
    private long _id;
    private InspectionDataBaseAdapter dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Cursor cursor = inspectDbManager.fetch(InspectionDataBaseAdapter.TABLE_ORG);

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        dbManager = new InspectionDataBaseAdapter(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView orgTextView = (TextView) view.findViewById(R.id.itemName);
                String orgName = orgTextView.getText().toString();

                String id = idTextView.getText().toString();
                _id = Long.parseLong(id);
                // 弹出警示框，确认是否删除
                showDeleteAlert(orgName, _id, InspectionDataBaseAdapter.TABLE_ORG);
            }
        });
    }

    /**
     * 这个方法用于配置右上角的添加操作员的按钮
     *
     * add_mem指向了AddItemActivity类
     * add_mem里包含了外检员需要用的数据库
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_record:
                Intent add_mem = new Intent(this, AddItemActivity.class);
                add_mem.putExtra("opTypeTable", InspectionDataBaseAdapter.TABLE_ORG);
                add_mem.putExtra("fromClass", this.getClass().toString());
                startActivity(add_mem);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
