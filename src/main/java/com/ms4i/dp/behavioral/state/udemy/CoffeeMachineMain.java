package com.ms4i.dp.behavioral.state.udemy;

import java.util.logging.Logger;

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
        coffeeMachine.returnTheCoin();
        coffeeMachine.pushTheButton();
        coffeeMachine.returnTheCoin();
        coffeeMachine.takeTheCup();
        coffeeMachine.returnTheCoin();

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

    Logger log = Logger.getLogger("State");

    void insertTheCoin(CoffeeMachine coffeeMachine);

    void pushTheButton(CoffeeMachine coffeeMachine);

    void takeTheCup(CoffeeMachine coffeeMachine);

    void returnTheCoin(CoffeeMachine coffeeMachine);
}

class NoCoinState implements State {

    public void insertTheCoin(CoffeeMachine coffeeMachine) {
        log.info("Moneta zostala wrzucona");
        coffeeMachine.state = new CoinInsertedState();
    }

    public void pushTheButton(CoffeeMachine coffeeMachine) {
        log.info("Wrzuc monete");
    }

    public void takeTheCup(CoffeeMachine coffeeMachine) {
        log.info("Wrzuc monete");
    }

    public void returnTheCoin(CoffeeMachine coffeeMachine) {
        log.info("Wrzuc monete");

    }
}

class CoinInsertedState implements State {

    public void insertTheCoin(CoffeeMachine coffeeMachine) {
        log.info("Moneta zostala juz wrzucona");
    }

    public void pushTheButton(CoffeeMachine coffeeMachine) {
        log.info("Nalewam kawe");
        coffeeMachine.state = new CupFullState();
    }

    public void takeTheCup(CoffeeMachine coffeeMachine) {
        log.info("Wcisnij guzik");
    }

    public void returnTheCoin(CoffeeMachine coffeeMachine) {
        log.info("Zwracam monete");
        coffeeMachine.state = new NoCoinState();
    }
}

class CupFullState implements State {

    public void insertTheCoin(CoffeeMachine coffeeMachine) {
        log.info("Zabierz kubek");
    }

    public void pushTheButton(CoffeeMachine coffeeMachine) {
        log.info("Zabierz najpierw kubek");
    }

    public void takeTheCup(CoffeeMachine coffeeMachine) {
        log.info("Zabrano kubek");
        coffeeMachine.state = new NoCoinState();
    }

    public void returnTheCoin(CoffeeMachine coffeeMachine) {
        log.info("Za pozno");
    }
}