package com.ms4i.dp.behavioral.command.head_simple;


/**
 * Project: arizona-ddi
 *
 * @author: johnee
 * @since: 03.11.2021
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {}

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
