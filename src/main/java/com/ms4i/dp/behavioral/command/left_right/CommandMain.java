package com.ms4i.dp.behavioral.command.left_right;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommandMain {
    public static void main(String[] args) {
        Robot robot = new Robot();
        CommandApp app = new CommandApp();
        app.addTask(new LeftCommand(robot));
        app.addTask(new LeftCommand(robot));
        app.addTask(new LeftCommand(robot));
        app.addTask(new RightCommand(robot));

        app.run();
    }
}

class Robot {
    public void left() {
        System.out.println("LEFT");
    }

    public void right() {
        System.out.println("RIGHT");
    }
}

interface Command {
    void execute();

    void undo();
}

class LeftCommand implements Command {
    private Robot robot;

    public LeftCommand(Robot robot) {
        this.robot = robot;
    }

    public void execute() {
        robot.left();
    }

    public void undo() {
        robot.right();
    }
}

class RightCommand implements Command {
    private Robot robot;

    public RightCommand(Robot robot) {
        this.robot = robot;
    }

    public void execute() {
        robot.right();
    }

    public void undo() {
        robot.left();
    }
}

class CommandApp {
    private List<Command> tasks = new ArrayList<>();

    public void addTask(Command task) {
        tasks.add(task);
    }

    public void run() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to do.");
        }
        Random rand = new Random();
        for (Command task : tasks) {
            int i = rand.nextInt((1 - 0) + 1) + 0;
            System.out.println(i);
            if (i == 0) {
                task.execute();
            } else {
                task.undo();
            }
        }

        tasks.clear();
    }
}