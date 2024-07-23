package com.example.warehouse;

public class Stuffuser {
    private int id;
    private String name_employee_id;
    private String name_stuff_id;
    private int count;
    private String data;
    private String data_refund;
    private String name_status_id;

    Stuffuser (int id, String name_employee_id, String name_stuff_id, int count, String data, String data_refund, String name_status_id)
    {
        this.id = id;
        this.name_employee_id = name_employee_id;
        this.name_stuff_id = name_stuff_id;
        this.count = count;
        this.data = data;
        this.data_refund = data_refund;
        this.name_status_id = name_status_id;
    }

    public int getId() {
        return id;
    }

    public String getName_employee_id() {
        return name_employee_id;
    }

    public String getName_stuff_id() {
        return name_stuff_id;
    }

    public int getCount() {
        return count;
    }

    public String getData() {
        return data;
    }

    public String getData_refund() {
        return data_refund;
    }

    public String getName_status_id() {
        return name_status_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName_employee_id(String name_employee_id) {
        this.name_employee_id = name_employee_id;
    }

    public void setName_stuff_id(String name_stuff_id) {
        this.name_stuff_id = name_stuff_id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setData_refund(String data_refund) {
        this.data_refund = data_refund;
    }

    public void setName_status_id(String name_status_id) {
        this.name_status_id = name_status_id;
    }
}
