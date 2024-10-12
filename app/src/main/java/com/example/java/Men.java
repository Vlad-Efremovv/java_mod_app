package com.example.java;

import java.io.Serializable;

public class Men implements Serializable {
    private String name;
    private Integer age;


    public Men(String name, Integer age) {
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
