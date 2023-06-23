package com.example.hifzdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EachStudent extends AppCompatActivity {

    Task tsk;
    TaskDB tskdb;

    TextView sabqi;
    Button next_btn;

    public void assign(String name,int id){
        tsk = tskdb.getTask(name, id);
        sabqi= findViewById(R.id.sabaqdata);

        sabqi.setText(tsk.getSabqi());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_each_student);

        try {
            next_btn=findViewById(R.id.button);

            String name = getIntent().getStringExtra("name");
            int id = Integer.parseInt(getIntent().getStringExtra("id"));

            tskdb=new TaskDB(EachStudent.this);

          assign(name,id);

           next_btn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   tskdb.next_task(name,id);
                   assign(name,id);
               }
           });

        }catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}