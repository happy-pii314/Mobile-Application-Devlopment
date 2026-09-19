package com.example.practical8;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    Button cameraButton;
    ImageView clickImage;

    // Camera permission
    ActivityResultLauncher<String> permissionLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.RequestPermission(),
                    granted -> {

                        if (granted) {
                            openCamera();
                        } else {
                            Toast.makeText(
                                    this,
                                    "Camera Permission Denied",
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    });

    // Camera result
    ActivityResultLauncher<Intent> cameraLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {

                        if (result.getResultCode() == RESULT_OK && result.getData() != null && result.getData().getExtras() != null) {

                            Bitmap image = (Bitmap)
                                    result.getData()
                                            .getExtras()
                                            .get("data");

                            if (image != null) {
                                clickImage.setImageBitmap(image);
                            }
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        cameraButton = findViewById(R.id.cameraButton);
        clickImage = findViewById(R.id.clickImage);

        cameraButton.setOnClickListener(v -> {

            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {

                openCamera();

            } else {
                permissionLauncher.launch(
                        Manifest.permission.CAMERA
                );
            }
        });
    }

    // Open Camera
    private void openCamera() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        cameraLauncher.launch(intent);
    }
}