package com.car.zadanie;

public class Car {
    private long id;
    private String mark;
    private String colour;
    private String model;

    public Car(long id, String mark, String colour, String model) {
        this.id = id;
        this.mark = mark;
        this.colour = colour;
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Car() {
    }
}
