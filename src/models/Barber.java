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
    /**
     * Time of shaving the hair.
     */
    private long timeShaving;
    /**
     * Identifier of the barber.
     */
    private int idClient;

    /**
     * Constructor of Barber
     * @param name Barber name
     * @param timeMaxShaving Maximum shaving time
     * @param shop Barber shop
     */
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
            timeShaving = (long) (Math.random() * (timeMaxShaving) + 1);
            idClient=customer.getIdCustomer();
            sleep(TimeUnit.SECONDS.toMillis(timeShaving));
            customer.setTimeShaving((int) timeShaving);
            System.out.println("CUSTOMER: " + this.getNameBarber() + "     Shaving time: " + timeShaving + "  for customer: " + customer.getIdCustomer());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public int getIdClient(){
        return idClient;
    }

    /**
     * @return Returns time shaving for a customer.
     */
    public int getTimeShaving(){
        return (int) timeShaving;
    }
    /**
     * Gets the barber name
     * @return String the barber name
     */
    public String getNameBarber() {
        return this.name;
    }

}
