package com.example.hifzdiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewStudent extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    List<Student>ll=new ArrayList<>();
    DBHandler studenDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);

        try {

            studenDB=new DBHandler(ViewStudent.this);

            Student s1=new Student(0,"umair","3456","first",R.drawable.d);
            Student s2=new Student(0,"umair2.0","3456","first",R.drawable.d);

           //ll.add(s1);ll.add(s2);
          //  ll.addAll(Arrays.asList(new Student()[]{s1,s2}));
            /*Toast.makeText(this, "Ok i am view student", Toast.LENGTH_SHORT).show();*/

            ll=studenDB.getStudents();

            recyclerView=findViewById(R.id.recylerViewStudent);
            recyclerView.setHasFixedSize(true);


            layoutManager=new LinearLayoutManager(ViewStudent.this);
            recyclerView.setLayoutManager(layoutManager);

            adapter=new studentAdapter(ll);
            recyclerView.setAdapter(adapter);


        }catch(Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}