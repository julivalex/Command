package com.company.stereo;

import com.company.display.Display;

public class Stereo implements Display {

    private String location;

    public Stereo(String name) {
        this.location = name;
    }

    void on() {
        display("stereo is on");
    }

    void off() {
        display("stereo is off");
    }

    void setCd() {
        display("is set for stereo CD");
    }

    void setDvd() {
        display("is set for stereo DVD");
    }

    void setRadio() {
        display("is set for stereo radio");
    }

    void setVolume(int volume) {
        display("is set stereo volume to " + volume);
    }

    @Override
    public void display(String description) {
        System.out.println(location + " " + description);
    }
}
