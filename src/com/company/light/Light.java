package com.company.light;

import com.company.display.Display;

public class Light implements Display {

    private String location;

    public Light(String name) {
        this.location = name;
    }

    void on() {
        display("light is on");
    }

    void off() {
        display("light is off");
    }

    @Override
    public void display(String description) {
        System.out.println(location + " " + description);
    }
}
