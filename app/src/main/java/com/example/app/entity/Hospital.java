package com.example.app.entity;


public class Hospital {

    private int id=0;
    private String name;;
    private int base_year;

    public Hospital() {
    }

    public Hospital(String name, int base_year) {
        this.name = name;
        this.base_year = base_year;
    }

    public Hospital(int id,String name, int base_year) {
        this.id = id;
        this.name = name;
        this.base_year = base_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBase_year() {
        return base_year;
    }

    public void setBase_year(int base_year) {
        this.base_year = base_year;
    }
}

