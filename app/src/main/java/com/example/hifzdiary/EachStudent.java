package com.example.hifzdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class EachStudent extends AppCompatActivity {

    Task tsk;
    TaskDB tskdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_student);

        try {
            String name = getIntent().getStringExtra("name");
            int id = Integer.parseInt(getIntent().getStringExtra("id"));

            tskdb=new TaskDB(EachStudent.this);

            tsk = tskdb.getTask(name, id);
            Toast.makeText(this, "ok so task is " + tsk.getSabaq(), Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}