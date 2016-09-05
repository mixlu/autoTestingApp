package com.example.qinlu.autotesting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by qinlu on 9/4/2016.
 */
public class UpdateItemActivity extends Activity implements View.OnClickListener {

    private EditText opnameText;
    private Button updateBtn, deleteBtn;

    private InspectionDataBaseAdapter dbManager;

    Intent intent;
    private long _id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("更新成员信息");

        setContentView(R.layout.popup_update_record);

        dbManager = new InspectionDataBaseAdapter(this);
        dbManager.open();

        opnameText = (EditText) findViewById(R.id.op_name);

        updateBtn = (Button) findViewById(R.id.btn_update);
        deleteBtn = (Button) findViewById(R.id.btn_delete);
        intent = getIntent();
        String id = intent.getStringExtra("_id");
        String name = intent.getStringExtra("itemName");
        _id = Long.parseLong(id);

        opnameText.setText(name);

        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String dbTable = intent.getStringExtra("opTypeTable");
        String fromClass = intent.getStringExtra("fromClass");
        switch (v.getId()) {
            case R.id.btn_update:
                String name = opnameText.getText().toString();
                // TODO: add regex check
                dbManager.updateItem(_id, name, dbTable);
                this.returnHome(fromClass);
                break;

            case R.id.btn_delete:
                dbManager.deleteItemFromTable(_id, dbTable);
                this.returnHome(fromClass);
                break;
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