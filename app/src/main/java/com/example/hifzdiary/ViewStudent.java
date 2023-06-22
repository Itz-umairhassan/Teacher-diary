package com.example.hifzdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewStudent extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);

        try {

            Student s1 = new Student();
            s1.setStudent_class("Third");
            s1.setStudent_name("umair");
            s1.setStudent_roll("908");

            Student s2 = new Student();
            s2.setStudent_class("Third99");
            s2.setStudent_name("umair2.0");
            s2.setStudent_roll("90899");

            ArrayList<Student> li = new ArrayList<>();

            li.add(s1);
            li.add(s2);
            Toast.makeText(this, "Ok i am view student", Toast.LENGTH_SHORT).show();

            /*recyclerView=findViewById(R.id.recylerViewStudent);
            recyclerView.setHasFixedSize(true);

            layoutManager=new LinearLayoutManager(ViewStudent.this);
            recyclerView.setLayoutManager(layoutManager);

            adapter=new studentAdapter(li);
            recyclerView.setAdapter(adapter);*/

        }catch(Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}