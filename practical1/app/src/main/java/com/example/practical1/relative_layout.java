package com.example.practical1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practical1.R;

public class relative_layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText userName, userPassword;
        Button loginBtn;

        userName = findViewById(R.id.userNameEditText);
        userPassword = findViewById(R.id.userPasswordEditText);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (userName.getText().toString().equals("User") && userPassword.getText().toString().equals("12345")) {
                    Toast.makeText(relative_layout.this, "Login Successful", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(relative_layout.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}