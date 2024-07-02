package com.example.warehouse;

public class User
{
    private int id;
    private String name;
    private String data;
    private String department;

    User(int id, String name, String data, String department)
    {
        this.id = id;
        this.name = name;
        this.data = data;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
