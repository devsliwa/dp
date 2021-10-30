package com.ms4i.dp.visitor.udemy;

import java.util.Arrays;
import java.util.List;

/**
 * Project: arizona-ddi
 *
 * @author: johnee
 * @since: 27.10.2021
 */
public class VisitorMain {

    public static void main(String[] args) {

        Treadmill treadmill = new Treadmill(400);
        Squash squash = new Squash(45);
        Weights weights = new Weights(50, 10);

        VisitorImpl visitor = new VisitorImpl();

        treadmill.accept(visitor);
        squash.accept(visitor);
        weights.accept(visitor);

        System.out.println("----------------------");

        List<Activity> activityList = Arrays.asList(treadmill, squash, weights);

        activityList.forEach(activity -> activity.accept(visitor));

    }

}

interface Visitor {

    void visit(Treadmill treadmill);
    void visit(Squash squash);
    void visit(Weights weights);
}

class VisitorImpl implements Visitor {

    @Override
    public void visit(Treadmill treadmill) {
        System.out.println("Calories burned running on treadmill: "
                + treadmill.getDistance() * 5);
    }

    @Override
    public void visit(Squash squash) {
        System.out.println("Calories burned playing squash: "
                + squash.getMinutesPlayed() * 20);
    }

    @Override
    public void visit(Weights weights) {
        System.out.println("Calories burned lifting weights: "
                + weights.getWeight() * weights.getReps() * 2);
    }
}

interface Activity {

    void accept(Visitor visitor);

}

class Treadmill implements Activity {

    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getDistance() {
        return distance;
    }
}

class Squash implements Activity {

    private int minutesPlayed;

    public Squash(int minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }
}

class Weights implements Activity {

    private int weight;
    private int reps;

    public Weights(int weight, int reps) {
        this.weight = weight;
        this.reps = reps;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getWeight() {
        return weight;
    }

    public int getReps() {
        return reps;
    }
}
