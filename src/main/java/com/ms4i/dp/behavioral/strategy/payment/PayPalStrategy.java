package com.ms4i.dp.behavioral.strategy.payment;

public class PayPalStrategy implements IPaymentStrategy {

    private String email;
    private String password;

    public PayPalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(String.format("Payed %s by paypayl .", amount));
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "PayPalStrategy{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
