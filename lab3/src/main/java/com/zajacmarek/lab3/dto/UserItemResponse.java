package com.zajacmarek.lab3.dto;

public class UserItemResponse {
    public UserItemResponse(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int id;
    public String name;
    public int age;
}
