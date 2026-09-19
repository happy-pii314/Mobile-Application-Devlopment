package com.example.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;


public class ExplicitIntentActivity1 extends AppCompatActivity {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_explicit_intent1);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> {
            finish();
        });
    }
}