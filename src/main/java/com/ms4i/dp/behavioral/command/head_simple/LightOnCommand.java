package com.ms4i.dp.behavioral.command.head_simple;

/**
 * Project: arizona-ddi
 *
 * @author: johnee
 * @since: 03.11.2021
 */
public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}
