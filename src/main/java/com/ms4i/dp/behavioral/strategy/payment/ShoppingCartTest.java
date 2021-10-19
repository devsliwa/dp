package com.ms4i.dp.behavioral.strategy.payment;

import java.util.Date;

public class ShoppingCartTest {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("Book of something", 10);
        Item item2 = new Item("Laptop", 40);

        cart.addItem(item1);
        cart.addItem(item2);

        //pay by paypal
        cart.pay(new PayPalStrategy("myemail@example.com", "mypwd"));

        //pay by credit card
        cart.pay(new CreditCardStrategy("Jan Sliwa", "1234567890123456", "786", new Date()));
    }
}
