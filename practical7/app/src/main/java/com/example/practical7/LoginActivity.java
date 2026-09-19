package com.example.practical7;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText loginUsername, loginPassword;
    Button getButton;
    UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        loginUsername = findViewById(R.id.loginUsername);
        loginPassword = findViewById(R.id.loginPassword);

        getButton = findViewById(R.id.getButton);

        userPreferences = new UserPreferences(this);

        getButton.setOnClickListener(v -> {

            String savedUsername = userPreferences.getUsername();

            String savedPassword = userPreferences.getPassword();

            String username = loginUsername.getText().toString();

            String password = loginPassword.getText().toString();

            if (username.equals(savedUsername) && password.equals(savedPassword)) {

                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}