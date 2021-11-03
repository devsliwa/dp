package com.ms4i.dp.behavioral.command.head_simple;

/**
 * Project: arizona-ddi
 *
 * @author: johnee
 * @since: 03.11.2021
 */
public class GarageDoor {
    public void up() {
        System.out.println("Garage Door is Open");
    }

    public void down() {
        System.out.println("Garage Door is Closed");
    }

    public void stop() {
        System.out.println("Garage Door is Stopped");
    }

    public void lightOn() {
        System.out.println("Garage light is on");
    }

    public void lightOff() {
        System.out.println("Garage light is off");
    }
}
