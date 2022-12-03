package models;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Customer extends Thread implements Comparable<Customer> {

    /**
     * Specifies the primary key of the customer entity.
     */
    private final int id;
    /**
     * Specifies the name of the customer entity.
     */
    private final String name;

    /**
     * Specifies the store that the customer will enter.
     */

    private final BarberShop shop;

    /**
     * Specifies the status if the customer was served or not.
     */
    private boolean state = false;

    private int timeAction;

    public Customer(int id, String name, BarberShop shop) {
        this.id = id;
        this.name = name;
        this.shop = shop;
    }

    public Customer(int id, String name, BarberShop shop,int timeAction) {
        this.id = id;
        this.name = name;
        this.shop = shop;
        this.timeAction = timeAction;
    }

    public int generateTimeAction(){
        return (new Random().nextInt(timeAction)) * 1000;
    }

    public void run() {
        enterToShop();
        try {
            sleep(TimeUnit.SECONDS.toMillis(5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean result = shop.getHaircut(this);
        exit(result);
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

    /**
     * @return Returns the state of the customer.
     */
    public boolean getStateCustomer() {
        return this.state;
    }

    /**
     * @return Get a number of the customer.
     */
    public int getIdCustomer() {
        return this.id;
    }

    /**
     * @return Name of the customer.
     */
    public String getNameCustomer() {
        return this.name;
    }

    /**
     * @param customer the object to be compared.
     * @return A negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Customer customer) {
        return Integer.compare(this.getIdCustomer(), customer.getIdCustomer());
    }
}