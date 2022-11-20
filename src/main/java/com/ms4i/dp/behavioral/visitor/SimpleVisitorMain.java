package com.ms4i.dp.behavioral.visitor;

/**
 * Project: arizona-ddi
 *
 * @author: johnee
 * @since: 27.10.2021
 */
public class SimpleVisitorMain {
    public static void main(String[] args) {
        Treadmill treadmill = new Treadmill(400);
        Squash squash = new Squash(45);

        VisitorImpl visitor = new VisitorImpl();

        treadmill.accept(visitor);
        squash.accept(visitor);
    }
}
interface Visitor {
    void visit(Treadmill treadmill);
    void visit(Squash squash);
}

class VisitorImpl implements Visitor {
    @Override
    public void visit(Treadmill treadmill) {
        System.out.println(treadmill.getDistance() * 5);
    }
    @Override
    public void visit(Squash squash) {
        System.out.println(squash.getMinutesPlayed() * 20);
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