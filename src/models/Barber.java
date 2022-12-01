package models;

import java.util.concurrent.TimeUnit;

public class Barber extends Thread {

    private BarberShop shop;

    public Barber(String name, BarberShop shop) {
        super(name);
        this.shop = shop;
    }

    @Override
    public void run() {
        while(true) {
            Customer customer = shop.getNextCustomer();
            shavingCustomer(customer.getIdCustomer());
            shop.finishHaircut(customer);
        }
    }

    private void shavingCustomer(int customer) {
        try {
            sleep(TimeUnit.SECONDS.toMillis(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Shaving " + customer);
    }

}
