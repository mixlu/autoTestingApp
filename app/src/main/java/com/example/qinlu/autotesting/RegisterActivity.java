package com.example.qinlu.autotesting;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by qinlu on 7/28/2016.
 */
public class RegisterActivity extends AppCompatActivity {
    EditText editTextUserEmail, editTextUserName, editTextPassword, editTextConfirmPassword;
    TextView btnCreateAccount;

    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_register);
        // get Instance of Database Adapter
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        // Get References of Views
        editTextUserEmail = (EditText)findViewById(R.id.editTextUserEmail);
        editTextUserName = (EditText)findViewById(R.id.editTextUserName);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextConfirmPassword = (EditText)findViewById(R.id.editTextConfirmPassword);

        btnCreateAccount = (TextView)findViewById(R.id.buttonCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String userEmail = editTextUserEmail.getText().toString();
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();
                // check if any of the fields are empty
                if(userEmail.equals("") || userName.equals("") || password.equals("") || confirmPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "请填入所有必要信息", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if user email already exist
                if(loginDataBaseAdapter.isUserExist(userEmail)) {
                    // TODO: Adding account updating logic or password retrieve logic
                    editTextUserEmail.setError("此帐户已存在");
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword)) {
                    editTextConfirmPassword.setError("两次输入密码不一致");
                    return;
                } else {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(userEmail, userName, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    // Redirect to page_login page after page_register
                    Intent intentLogin = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intentLogin);
                }
            }
        });
    }
}
