package test;

import models.Barber;
import models.BarberShop;
import models.Customer;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Test1 {


    public static final int NUM_SEATS = 5;
    public static final int NUM_CUST = 12;

    public static void main(String[] args) {

        BarberShop shop = new BarberShop(NUM_SEATS);
        new Barber("Barber1", shop).start();

        new Customer(1, "Customer " + 1, shop).start();
        new Customer(2, "Customer " + 2, shop).start();
        new Customer(5, "Customer " + 5, shop).start();
        new Customer(4, "Customer " + 4, shop).start();
        new Customer(3, "Customer " + 3, shop).start();

        try {
            sleep(TimeUnit.SECONDS.toMillis(10));
            System.out.println("All customers are in the shop");
            for (Customer customer : shop.getListCustomersExit()) {
                System.out.println(customer.getNameCustomer() + "  State:" + customer.getStateCustomer());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        try {
            sleep(TimeUnit.SECONDS.toMillis(25));
            new Customer(4, "Customer " + 4, shop).start();
            new Customer(1, "Customer " + 1, shop).start();
            new Customer(2, "Customer " +2, shop).start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            sleep(TimeUnit.SECONDS.toMillis(45));
            System.out.println("All customers are in the shop");
            for (Customer customer : shop.getListCustomersExit()) {
                System.out.println(customer.getNameCustomer() + "  State:" + customer.getStateCustomer());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
