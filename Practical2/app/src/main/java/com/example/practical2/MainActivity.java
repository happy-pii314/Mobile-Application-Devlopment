package com.example.practical2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.practical2.ActivityForResult;
import com.example.practical2.R;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button explicitButton, implicitButton, resultButton;

    // Activity For Result
    ActivityResultLauncher<Intent> resultLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(), result -> {

                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            String value = result.getData().getStringExtra("result");

                            editText.setText(value);
                        }
                    }
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        explicitButton = findViewById(R.id.explicitButton);
        implicitButton = findViewById(R.id.implicitButton);
        resultButton = findViewById(R.id.resultButton);

        // Explicit Intent
        explicitButton.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, ExplicitIntentActivity1.class);

            startActivity(intent);
        });

        // Implicit Intent
        implicitButton.setOnClickListener(view -> {

            String url = editText.getText().toString();

            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

            startActivity(intent);
        });

        // Start Activity For Result
        resultButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ActivityForResult.class
            );

            resultLauncher.launch(intent);
        });
    }
}