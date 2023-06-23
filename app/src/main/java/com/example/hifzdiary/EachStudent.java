package com.example.hifzdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class EachStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_student);

        Toast.makeText(this, "Ok so new student is here "+getIntent().getStringExtra("id"), Toast.LENGTH_SHORT).show();
    }
}