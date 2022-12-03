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
        new Barber("Barber 1", 4, shop).start();
        new Barber("Barber 2", 10, shop).start();


        new Customer(1, "Customer " + 1, (int) (Math.random() * 10 + 1), shop).start();
        new Customer(2, "Customer " + 2, (int) (Math.random() * 10 + 1), shop).start();
        new Customer(3, "Customer " + 3, (int) (Math.random() * 10 + 1), shop).start();
        new Customer(4, "Customer " + 4, (int) (Math.random() * 10 + 1), shop).start();
        new Customer(5, "Customer " + 5, (int) (Math.random() * 10 + 1), shop).start();
        new Customer(6, "Customer " + 6, (int) (Math.random() * 10 + 1), shop).start();


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
            new Customer(7, "Customer " + 7, (int) (Math.random() * 10 + 1), shop).start();
            new Customer(8, "Customer " + 8, (int) (Math.random() * 10 + 1), shop).start();
            new Customer(9, "Customer " + 9, (int) (Math.random() * 10 + 1), shop).start();
            new Customer(10, "Customer " + 10, (int) (Math.random() * 10 + 1), shop).start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            sleep(TimeUnit.SECONDS.toMillis(70));
            System.out.println("All customers are in the shop");
            for (Customer customer : shop.getListCustomersExit()) {
                System.out.println(customer.getNameCustomer() + "  State:" + customer.getStateCustomer());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
