package com.ms4i.dp.behavioral.strategy.singlefile;

public class PaymentMain {

    public static void main(String[] args) {
        PaymentInvoker pi = new PaymentInvoker();

        pi.pay(new P1Strategy());
        pi.pay(new P2Strategy());
    }
}

interface IPStrategy {
    void pay();
}

class P1Strategy implements IPStrategy {
    @Override
    public void pay() {
        System.out.println("pay nr 1.");
    }
}

class P2Strategy implements IPStrategy {
    @Override
    public void pay() {
        System.out.println("pay nr 2.");
    }
}

class PaymentInvoker {
    public void pay(IPStrategy strategy) {
        strategy.pay();
    }
}
