package models;

import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class Customer extends Thread implements Comparable<Customer> {

    private int id;
    private String name;
    private BarberShop shop;

    private boolean state = false;

    public Customer(int id, String name, BarberShop shop) {
        this.id = id;
        this.name = name;
        this.shop = shop;
    }

    public void run() {
        enterToShop();
        try {
            sleep(TimeUnit.SECONDS.toMillis(5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        boolean validateChair = shop.validateChair(this);
        boolean result = shop.getHaircut(this);
        exit(result);
//        shop.exitCustomer(this);
    }

    private void enterToShop() {
        try {
            sleep(TimeUnit.SECONDS.toMillis(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shop.enterCustomer(this);
        System.out.println(this.name + " entered the shop!");
    }

    private void exit(boolean result) {
        System.out.println(this.name + " exited the shop " + (result ? "WITH haircut" : "WITHOUT haircut"));
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getStateCustomer() {
        return this.state;
    }

    public int getIdCustomer() {
        return this.id;
    }

    public String getNameCustomer() {
        return this.name;
    }

    @Override
    public int compareTo(Customer employee) {
        if(this.getIdCustomer() > employee.getIdCustomer()) {
            return 1;
        } else if (this.getIdCustomer() < employee.getIdCustomer()) {
            return -1;
        } else {
            return 0;
        }
    }

}
