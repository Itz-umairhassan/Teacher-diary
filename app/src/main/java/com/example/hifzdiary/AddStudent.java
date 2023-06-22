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
    DBHandler studentdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        try {
            // create a new object of db hanlder class for student...
            studentdb=new DBHandler(AddStudent.this);
            add_student = findViewById(R.id.addStudent);
            studentname = findViewById(R.id.studentName);
            studentroll = findViewById(R.id.studentRoll);
            studentclass = findViewById(R.id.studentClass);

            add_student.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String student_name=studentname.getText().toString();
                    String student_roll=studentroll.getText().toString();
                    String student_class=studentclass.getText().toString();

                    if(student_class.isEmpty() || student_roll.isEmpty() || student_name.isEmpty()){
                        Toast.makeText(AddStudent.this, "Fields are empty", Toast.LENGTH_SHORT).show();

                    }else{
                        studentdb.addNewStudent(student_name,student_roll,student_class);

                        Toast.makeText(AddStudent.this, "Student "+student_name+" is added ", Toast.LENGTH_SHORT).show();
                        studentclass.setText("");
                        studentname.setText("");
                        studentroll.setText("");
                    }
                }
            });
        }catch(Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}