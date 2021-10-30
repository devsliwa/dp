package com.ms4i.dp.behavioral.state.simple;

public class StateMain {
    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.insertCoin();
        machine.insertCoin();
        machine.returnCoin();
        machine.getItem();
        machine.insertCoin();
        machine.getItem();
    }
}

class Machine {
    IState state = new NoCoinState();

    public void insertCoin() {
        state.insertCoin(this);
    }

    public void returnCoin() {
        state.returnCoin(this);
    }

    public void getItem() {
        state.getItem(this);
    }
}

interface IState {
    void insertCoin(Machine machine);

    void returnCoin(Machine machine);

    void getItem(Machine machine);
}

class NoCoinState implements IState {
    public void insertCoin(Machine machine) {
        System.out.println("Paid");
        machine.state = new PaidState();
    }

    public void returnCoin(Machine machine) {
        System.out.println("I can't. No money");
    }

    public void getItem(Machine machine) {
        System.out.println("I can't. No money");
    }
}

class PaidState implements IState {
    public void insertCoin(Machine machine) {
        System.out.println("I can not! Coin is in.");
    }

    public void returnCoin(Machine machine) {
        System.out.println("Money back.");
        machine.state = new NoCoinState();
    }

    public void getItem(Machine machine) {
        System.out.println("Get item.");
        machine.state = new NoCoinState();
    }
}

