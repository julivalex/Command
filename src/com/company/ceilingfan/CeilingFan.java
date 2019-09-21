package com.company.ceilingfan;

import com.company.display.Display;

public class CeilingFan implements Display {

    static final int HIGH = 3;
    static final int MEDIUM = 2;
    static final int LOW = 1;
    static final int OFF = 0;
    private String location;
    private int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    void high() {
        speed = HIGH;
        display("ceiling fan is on high");
    }

    void medium() {
        speed = MEDIUM;
        display("ceiling fan is on medium");
    }

    void low() {
        speed = LOW;
        display("ceiling fan is on low");
    }

    void off() {
        speed = OFF;
        display("ceiling fan is off");
    }

    int getSpeed() {
        return speed;
    }

    @Override
    public void display(String description) {
        System.out.println(location + " " + description);
    }
}
