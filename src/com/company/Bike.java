package com.company;

public class Bike {


    String Name;
    String Producer;
    String Type;
    String Color;
    int tires;
    Boolean Gears;

    public Bike(String name, String producer, String type, String color, int tires, Boolean gears) {
        Name = name;
        Producer = producer;
        Type = type;
        Color = color;
        this.tires = tires;
        Gears = gears;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getTires() {
        return tires;
    }

    public void setTires(int tires) {
        this.tires = tires;
    }

    public Boolean getGears() {
        return Gears;
    }

    public void setGears(Boolean gears) {
        Gears = gears;
    }
}
