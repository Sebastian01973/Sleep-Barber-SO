package test;

import models.Barber;
import models.BarberShop;
import models.Customer;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Test2 {

    public static final int NUM_SEATS = 5;
    public static final int NUM_CUST = 12;


    public static void main(String[] args) {

        BarberShop shop = new BarberShop(NUM_SEATS);
        new Barber("Barber1",4, shop).start();

        for (int i = 0; i < NUM_CUST; i++)
//            new Customer(i, priority, "Customer " + i, shop).start();


        try {
            sleep(TimeUnit.SECONDS.toMillis(30));
            System.out.println("All customers are in the shop");
            for (Customer customer : shop.getListCustomersExit()) {
                System.out.println(customer.getNameCustomer() + "  State:" + customer.getStateCustomer());
            }
        } catch (
                InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
