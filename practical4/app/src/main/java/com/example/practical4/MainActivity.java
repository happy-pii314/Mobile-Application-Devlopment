package com.example.practical4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<student> students;
    studentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        students = new ArrayList<>();

        students.add(new student("manav", "Surat", R.drawable.student));
        students.add(new student("alpesh", "Ahmedabad", R.drawable.student));
        students.add(new student("dharav", "Vadodara", R.drawable.student));
        students.add(new student("harsh", "Rajkot", R.drawable.student));

        adapter = new studentAdapter(students);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}