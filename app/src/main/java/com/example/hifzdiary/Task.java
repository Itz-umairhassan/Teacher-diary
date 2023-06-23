package com.example.hifzdiary;

public class Task {
    private int id;
    private String name;
    private String sabaq;
    private int sabqi,manzil;

    public Task(int id,String name,String sabaq,int sabqi,int manzil){
        this.id=id;
        this.name=name;
        this.sabaq=sabaq;
        this.sabqi=sabqi;
        this.manzil=manzil;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setManzil(int manzil) {
        this.manzil = manzil;
    }

    public int getManzil() {
        return manzil;
    }

    public void setSabaq(String sabaq) {
        this.sabaq = sabaq;
    }

    public int getSabqi() {
        return sabqi;
    }

    public String getSabaq() {
        return sabaq;
    }

    public void setSabqi(int sabqi) {
        this.sabqi = sabqi;
    }

}
