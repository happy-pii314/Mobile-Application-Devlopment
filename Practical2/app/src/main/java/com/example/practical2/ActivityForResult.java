package com.example.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ActivityForResult extends AppCompatActivity {

    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);

        sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("result", "Result Received");
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}