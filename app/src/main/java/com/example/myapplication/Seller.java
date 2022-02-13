package com.example.myapplication;

public class Seller {
    private String name;
    private String phno;
    private String crop;
    private String qua;
    public Seller(){}
    public Seller(String name, String phno, String crop, String qua) {
        this.name = name;
        this.phno = phno;
        this.crop = crop;
        this.qua = qua;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public String getQua() {
        return qua;
    }

    public void setQua(String qua) {
        this.qua = qua;
    }
}
