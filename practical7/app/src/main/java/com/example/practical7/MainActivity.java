package com.example.practical7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button saveButton, loginButton;
    UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        saveButton = findViewById(R.id.saveButton);
        loginButton = findViewById(R.id.loginButton);

        userPreferences = new UserPreferences(this);

        // Save Data
        saveButton.setOnClickListener(v -> {

            userPreferences.saveData(username.getText().toString(), password.getText().toString()
            );

        });

        // Open Login Page
        loginButton.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, LoginActivity.class
            );

            startActivity(intent);

        });
    }
}