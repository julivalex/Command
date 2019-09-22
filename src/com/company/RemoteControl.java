package com.company;

import com.company.nocommand.NoCommand;

/**
 * Инициатор
 */
class RemoteControl {

    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;

    RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    void undoButtonWasPushed() {
        undoCommand.undo();
    }

    public String toString() {
        StringBuffer stringBuffer;
        stringBuffer = new StringBuffer();
        stringBuffer.append("\n------ Remote Control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuffer
                    .append("[slot ")
                    .append(i).append("] ")
                    .append(onCommands[i].getClass().getName())
                    .append("   ")
                    .append(offCommands[i].getClass().getName())
                    .append("\n");
        }
        stringBuffer
                .append("[undo] ")
                .append(undoCommand.getClass().getName())
                .append("\n");
        return stringBuffer.toString();
    }
}
