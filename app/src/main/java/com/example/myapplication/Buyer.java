package com.example.myapplication;

import java.io.Serializable;

public class Buyer implements Serializable {
    private String name;
    private String phno;
    private String crop;
    private String qua;
    private Seller info;
    public Buyer(){}

    public Buyer(String name, String phno, String crop, String qua, Seller info) {
        this.name = name;
        this.phno = phno;
        this.crop = crop;
        this.qua = qua;
        this.info = info;
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

    public Seller getInfo() {
        return info;
    }

    public void setInfo(Seller info) {
        this.info = info;
    }
}
