package com.example.hifzdiary;

import android.media.Image;

public class Student {

    private int id;
    private String student_name;
    private String student_roll;
   private  String student_class;
   private int student_image_id;

public Student(){}

    public Student(int id,String name,String roll,String clas,int iid){
    this.id=id;
    this.student_image_id=iid;
    this.student_class=clas;
    this.student_roll=roll;
    this.student_name=name;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setStudent_image_id(int student_image_id) {
        this.student_image_id = student_image_id;
    }

    public int getStudent_image_id() {
        return student_image_id;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_roll(String student_roll) {
        this.student_roll = student_roll;
    }


    public String getStudent_name() {
        return student_name;
    }

    public String getStudent_roll() {
        return student_roll;
    }

    public String getStudent_class() {
        return student_class;
    }

}
