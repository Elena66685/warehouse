package com.example.warehouse;

public class Stuff {
    private int id;
    private String name;
    private String weight;
    private int number;
    private String type_id;

    Stuff(int id, String name, String weight, int number, String type_id)
    {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.number = number;
        this.type_id = type_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getType_id() {
        return type_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getWeight() {
        return weight;





    }
}
