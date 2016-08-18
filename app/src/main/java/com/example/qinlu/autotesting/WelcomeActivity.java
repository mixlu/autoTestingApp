package com.example.qinlu.autotesting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by qinlu on 8/17/16.
 * 欢迎主界面
 */
public class WelcomeActivity extends AppCompatActivity {
    TextView signin;
    LinearLayout get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_welcome);

        get = (LinearLayout)findViewById(R.id.get);
        signin = (TextView)findViewById(R.id.signin);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(it);

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(it);
            }
        });

    }
}

