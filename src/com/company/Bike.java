package com.company;

public class Bike {


    String Name;
    String Producer;
    String Type;
    String Color;
    int tires;
    String Gears;

    public Bike(String name, String producer, String type, String color, int tires, String gears) {
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


    public String getProducer() {
        return Producer;
    }

    public String getType() {
        return Type;
    }
    public String getColor() { return Color; }
    public int getTires() { return tires; }
    public String getGears() { return Gears; }
    public void setName(String name) { Name = name; }
    public void setProducer(String producer) { Producer = producer; }
    public void setType(String type) { Type = type; }
    public void setColor(String color) { Color = color; }
    public void setTires(int tires) { this.tires = tires; }
    public void setGears(String gears) { Gears = gears; }
}
