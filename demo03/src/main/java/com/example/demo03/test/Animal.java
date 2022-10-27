package com.example.demo03.test;

public class Animal {
    private String name;
    private String color;

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void get() {
        System.out.printf("name= %s, age= %s", name, color);
    }
}
