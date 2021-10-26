package com.ms4i.dp.behavioral.state.udemy;

/**
 * Project: arizona-ddi
 *
 * @author: johnee
 * @since: 26.10.2021
 */
public class CoffeeMachineMain {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.insertTheCoin();
        coffeeMachine.pushTheButton();
        coffeeMachine.takeTheCup();

    }
}


class CoffeeMachine {

    State state;

    public CoffeeMachine() {
        state = new NoCoinState();
    }

    public void insertTheCoin() {

        state.insertTheCoin(this);

    }

    public void pushTheButton() {
        state.pushTheButton(this);
    }

    public void takeTheCup() {
        state.takeTheCup(this);
    }

    public void returnTheCoin() {
        state.returnTheCoin(this);
    }
}

interface State {

    void insertTheCoin(CoffeeMachine coffeeMachine);
    void pushTheButton(CoffeeMachine coffeeMachine);
    void takeTheCup(CoffeeMachine coffeeMachine);
    void returnTheCoin(CoffeeMachine coffeeMachine);
}

class NoCoinState implements State {

    public void insertTheCoin(CoffeeMachine coffeeMachine) {
        System.out.println("Moneta zostala wrzucona");
        coffeeMachine.state = new CoinInsertedState();
    }

    public void pushTheButton(CoffeeMachine coffeeMachine) {
        System.out.println("Wrzuc monete");
    }

    public void takeTheCup(CoffeeMachine coffeeMachine) {
        System.out.println("Wrzuc monete");
    }

    public void returnTheCoin(CoffeeMachine coffeeMachine) {
        System.out.println("Wrzuc monete");

    }
}

class CoinInsertedState implements State {

    public void insertTheCoin(CoffeeMachine coffeeMachine) {
        System.out.println("Moneta zostala juz wrzucona");
    }

    public void pushTheButton(CoffeeMachine coffeeMachine) {
        System.out.println("Nalewam kawe");
        coffeeMachine.state = new CupFullState();
    }

    public void takeTheCup(CoffeeMachine coffeeMachine) {
        System.out.println("Wcisnij guzik");
    }

    public void returnTheCoin(CoffeeMachine coffeeMachine) {
        System.out.println("Zwracam monete");
        coffeeMachine.state = new NoCoinState();
    }
}

class CupFullState implements State {

    public void insertTheCoin(CoffeeMachine coffeeMachine) {
        System.out.println("Zabierz kubek");
    }

    public void pushTheButton(CoffeeMachine coffeeMachine) {
        System.out.println("Zabierz najpierw kubek");
    }

    public void takeTheCup(CoffeeMachine coffeeMachine) {
        System.out.println("Zabrano kubek");
        coffeeMachine.state = new NoCoinState();
    }

    public void returnTheCoin(CoffeeMachine coffeeMachine) {
        System.out.println("Za pozno");
    }
}