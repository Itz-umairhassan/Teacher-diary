package com.example.hifzdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    EditText studentname;
    EditText studentclass;
    EditText studentroll;
    Button add_student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        try {
            add_student = findViewById(R.id.addStudent);
            studentname = findViewById(R.id.studentName);
            studentroll = findViewById(R.id.studentRoll);
            studentclass = findViewById(R.id.studentClass);

            add_student.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                }
            });
        }catch(Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}