package com.company.garagedoor;

import com.company.display.Display;

public class GarageDoor implements Display {

    private String location;

    public GarageDoor(String name) {
        this.location = name;
    }

    void up() {
        display("garage door is open");
    }

    void down() {
        display("garage door is close");
    }

    void stop() {
        display("garage door is stop");
    }

    void lightOn() {
        display("light of garage door is on");
    }

    void lightOff() {
        display("light of garage door is off");
    }

    @Override
    public void display(String description) {
        System.out.println(location + " " + description);
    }
}
