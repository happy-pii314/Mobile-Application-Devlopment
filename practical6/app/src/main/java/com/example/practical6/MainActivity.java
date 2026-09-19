package com.example.practical6;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText studentName, studentEnroll, studentSem;
    Button addStudent;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        studentName = findViewById(R.id.studentName);
        studentEnroll = findViewById(R.id.studentEnroll);
        studentSem = findViewById(R.id.studentSem);
        addStudent = findViewById(R.id.addStudent);

        dbHandler = new DBHandler(this);

        addStudent.setOnClickListener(v -> {

            String name = studentName.getText().toString();
            String enroll = studentEnroll.getText().toString();
            String semester = studentSem.getText().toString();

            dbHandler.addStudent(name, enroll, semester);

            Toast.makeText(this, "Student Saved Successfully", Toast.LENGTH_SHORT).show();

            studentName.setText("");
            studentEnroll.setText("");
            studentSem.setText("");
        });

    }


}
