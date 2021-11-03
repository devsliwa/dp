package com.ms4i.dp.behavioral.command.head_simple;

/**
 * Project: arizona-ddi
 *
 * @author: johnee
 * @since: 03.11.2021
 */
public class GarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.up();
    }
}
