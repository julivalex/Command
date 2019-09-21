package com.company;

import com.company.ceilingfan.CeilingFan;
import com.company.ceilingfan.CeilingFanMediumCommand;
import com.company.ceilingfan.CeilingFanOffCommand;
import com.company.ceilingfan.CeilingFanHighCommand;
import com.company.garagedoor.GarageDoor;
import com.company.garagedoor.GarageDoorDownCommand;
import com.company.garagedoor.GarageDoorUpCommand;
import com.company.light.Light;
import com.company.light.LightOffCommand;
import com.company.light.LightOnCommand;
import com.company.macrocommand.MacroCommand;
import com.company.stereo.Stereo;
import com.company.stereo.StereoOffCommand;
import com.company.stereo.StereoOnWithCdCommand;

public class RemoteLoader {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor("Garden");
        Stereo stereo = new Stereo("Living Room");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

        StereoOnWithCdCommand stereoOnWithCd = new StereoOnWithCdCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        Command[] partyOn = { livingRoomLightOn, kitchenLightOn, stereoOnWithCd };
        Command[] partyOff = { livingRoomLightOff, kitchenLightOff, stereoOff };

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, ceilingFanMedium, ceilingFanOff);
        remoteControl.setCommand(3, ceilingFanHigh, ceilingFanOff);
        remoteControl.setCommand(4, garageDoorUp, garageDoorDown);
        remoteControl.setCommand(5, stereoOnWithCd, stereoOff);
        remoteControl.setCommand(6, partyOnMacro, partyOffMacro);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);

        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);

        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);

        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);

        remoteControl.onButtonWasPushed(5);
        remoteControl.offButtonWasPushed(5);

        System.out.println("--- Pushing Macro On ---");
        remoteControl.onButtonWasPushed(6);

        System.out.println("--- Pushing Macro Off ---");
        remoteControl.offButtonWasPushed(6);
    }
}
