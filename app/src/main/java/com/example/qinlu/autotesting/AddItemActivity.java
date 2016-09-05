package com.example.qinlu.autotesting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by qinlu on 9/4/2016.
 */
public class AddItemActivity extends Activity implements OnClickListener {

    private Button addBtn;
    private EditText opnameEditText;

    private InspectionDataBaseAdapter dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("添加新成员");

        setContentView(R.layout.popup_add_record);

        opnameEditText = (EditText) findViewById(R.id.op_name);

        addBtn = (Button) findViewById(R.id.add_record);

        dbManager = new InspectionDataBaseAdapter(this);
        dbManager.open();
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = getIntent();
        // 获取到不同的检验员页面的数据库的表
        String opTypeDbTable = intent.getStringExtra("opTypeTable");
        String fromClass = intent.getStringExtra("fromClass");
        if (v.getId() == R.id.add_record) {
            final String itemName = opnameEditText.getText().toString();
            // TODO: add regex check
            if (!dbManager.isExistedItem(itemName, opTypeDbTable)) {
                dbManager.insertItemToTable(itemName, opTypeDbTable);
            } else {
                Toast.makeText(AddItemActivity.this, String.format("\"" + itemName + "\" 已存在!"), Toast.LENGTH_LONG).show();
            }
            this.returnHome(fromClass);
        }
    }

    public void returnHome(String fromClass) {
        Class callerClass = BaseItemManagementActivity.getCallerClass(fromClass);
        if (callerClass != null) {
            Intent home_intent = new Intent(getApplicationContext(), callerClass)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(home_intent);
        } else {
            finish();
        }
    }
}