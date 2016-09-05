package com.example.qinlu.autotesting;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by qinlu on 9/5/2016.
 */
public class PlatePrefixManagementActivity extends BaseItemManagementActivity {
    private SimpleCursorAdapter adapter;
    final String[] from = new String[] { "_id", "PLATE_PREFIX" };
    final int[] to = new int[] { R.id.id, R.id.itemName };
    private long _id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Cursor cursor = inspectDbManager.fetch(InspectionDataBaseAdapter.TABLE_PLATE);

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);

                String id = idTextView.getText().toString();
                _id = Long.parseLong(id);
                // TODO: add delete item logic
                Toast.makeText(PlatePrefixManagementActivity.this, "deleting " + id, Toast.LENGTH_LONG).show();
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
                add_mem.putExtra("opTypeTable", InspectionDataBaseAdapter.TABLE_PLATE);
                add_mem.putExtra("fromClass", this.getClass().toString());
                startActivity(add_mem);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
