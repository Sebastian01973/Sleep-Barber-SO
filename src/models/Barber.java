package models;

import java.util.concurrent.TimeUnit;

public class Barber extends Thread {

    /**
     * The shop where this barber works.
     */
    private final BarberShop shop;

    /**
     * Specifies the time maximum that the barber will take to cut the hair.
     */
    private final int timeMaxShaving;
    private String name;

    public Barber(String name,int timeMaxShaving ,BarberShop shop) {
        super(name);
        this.shop = shop;
        this.timeMaxShaving = timeMaxShaving;
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            Customer customer = shop.getNextCustomer();
            shavingCustomer(customer);
            shop.finishHaircut(customer);
        }
    }

    /**
     * @param customer Customer that the barber will cut the hair.
     */
    private void shavingCustomer(Customer customer) {
        try {
            long timeShaving = (long) (Math.random() * (timeMaxShaving) + 3);
            sleep(TimeUnit.SECONDS.toMillis(timeShaving));
            customer.setTimeShaving((int) timeShaving);
            System.out.println("CUSTOMER: " + this.getNameBarber() + "     Shaving time: " + timeShaving + "  for customer: " + customer.getIdCustomer());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNameBarber() {
        return this.name;
    }

}
