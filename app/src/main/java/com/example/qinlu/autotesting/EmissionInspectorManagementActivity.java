package com.example.qinlu.autotesting;

import android.app.Activity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by qinlu on 8/14/16.
 * 废气检验员管理 页面
 */
public class EmissionInspectorManagementActivity extends BaseItemManagementActivity {
    private SimpleCursorAdapter adapter;
    final String[] from = new String[] { "_id", "OPNAME" };
    final int[] to = new int[] { R.id.id, R.id.opname };

    /**
     * 这个方法在页面创建时执行
     *
     * 配置了ClickListener用于控制更新操作员的方法
     * 如果方法被激活，页面将会指向UpdateItemActivity类
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Cursor cursor = inspectDbManager.fetch(InspectionDataBaseAdapter.TABLE_EMISSION);

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView nameTextView = (TextView) view.findViewById(R.id.opname);

                String id = idTextView.getText().toString();
                String name = nameTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), UpdateItemActivity.class);
                modify_intent.putExtra("itemName", name);
                modify_intent.putExtra("_id", id);
                modify_intent.putExtra("opTypeTable", InspectionDataBaseAdapter.TABLE_EMISSION);
                modify_intent.putExtra("fromClass", this.getClass().toString());

                startActivity(modify_intent);
            }
        });
    }
    /**
     * 这个方法用于配置右上角的添加操作员的按钮
     *
     * add_mem指向了AddItemActivity类
     * add_mem里包含了废气管理员需要用的数据库 opTypeTable
     * add_mem里包含了这个类的名字 fromClass
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_record:
                Intent add_mem = new Intent(this, AddItemActivity.class);
                add_mem.putExtra("opTypeTable", InspectionDataBaseAdapter.TABLE_EMISSION);
                add_mem.putExtra("fromClass", this.getClass().toString());
                startActivity(add_mem);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
