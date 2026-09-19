package com.example.practical10;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button animatedButton;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        animatedButton = findViewById(R.id.animatedButton);
        imageView = findViewById(R.id.imageView);

        animatedButton.setOnClickListener(v -> {

            Animation animation =
                    AnimationUtils.loadAnimation(this, R.anim.blink);

            imageView.startAnimation(animation);
        });
    }
}