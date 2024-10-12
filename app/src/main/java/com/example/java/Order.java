package com.example.java;

import java.io.Serializable;

public class Order implements Serializable {
    private String name;
    private Integer age;


    public Order(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
