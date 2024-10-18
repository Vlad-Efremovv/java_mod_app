package com.example.java;

import java.io.Serializable;

public class Order implements Serializable {
    private String mainСourse;
    private String course;
    private String[] dip;

    private String name;
    private String adres;
    private String phone;

    public void setMainСourse(String mainСourse) {
        this.mainСourse = mainСourse;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String[] getDip() {
        return dip;
    }

    public void setDip(String[] dip) {
        this.dip = dip;
    }

    private String time;

    public Order(String mainСourse, String course, String[] dip) {
        this.mainСourse = mainСourse;
        this.course = course;
        this.dip = dip;
    }

    public String getCourse() {
        return course;
    }

    public String getMainСourse() {
        return mainСourse;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}