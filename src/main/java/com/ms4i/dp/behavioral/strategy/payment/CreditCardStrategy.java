package com.ms4i.dp.behavioral.strategy.payment;

import java.util.Date;

public class CreditCardStrategy implements IPaymentStrategy {

    private String name;
    private String cardNumber;
    private String cvv;
    private Date dateOfExpiry;

    public CreditCardStrategy(String name, String cardNumber, String cvv, Date dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(String.format("Payed %s by credit card.", amount));
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "CreditCardStrategy{name='" + this.name + "', cardNumber='" + this.cardNumber + "', cvv='" + this.cvv + "', dateOfExpiry=" + this.dateOfExpiry + "}";
    }
}
