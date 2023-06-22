package com.example.hifzdiary;

import android.media.Image;

public class Student {

    private String student_name;
    private String student_roll;
   private  String student_class;
   private Image student_image;


    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_roll(String student_roll) {
        this.student_roll = student_roll;
    }

    public void setStudent_image(Image student_image) {
        this.student_image = student_image;
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

    public Image getStudent_image() {
        return student_image;
    }
}
