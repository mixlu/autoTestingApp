package com.example.qinlu.autotesting;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by qinlu on 7/28/2016.
 */
public class SignUpActivity extends Activity{
    EditText editTextUserEmail, editTextUserName, editTextPassword, editTextConfirmPassword;
    Button btnCreateAccount;

    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        // get Instance of Database Adapter
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        // Get References of Views
        editTextUserEmail = (EditText)findViewById(R.id.editTextUserEmail);
        editTextUserName = (EditText)findViewById(R.id.editTextUserName);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextConfirmPassword = (EditText)findViewById(R.id.editTextConfirmPassword);

        btnCreateAccount = (Button)findViewById(R.id.buttonCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String userEmail = editTextUserEmail.getText().toString();
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();
                // check if any of the fields are empty
                if(userName.equals("") || password.equals("") || confirmPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please fill in all inputs", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if user already exist
                if(loginDataBaseAdapter.isUserExist(userEmail)) {
                    // TODO: Adding account updating logic or password retrieve logic
                    Toast.makeText(getApplicationContext(), "Account already existed", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(userEmail, userName, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    // Redirect to login page after register
                    Intent intentLogin = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intentLogin);
                }
            }
        });
    }
}
