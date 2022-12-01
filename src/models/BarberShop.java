package models;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BarberShop {

    private int numSeats;
    private boolean done = false;
    private ArrayList<Customer> listCustomers;
    private ArrayList<Customer> listCustomerExit;
    private ArrayList<Customer> customersWithOutHaircut;

    private PriorityQueue<Customer> customersInShop;

    public BarberShop(int numSeats) {
        this.numSeats = numSeats;
        this.listCustomers = new ArrayList<>();
        this.listCustomerExit = new ArrayList<>();
        this.customersWithOutHaircut = new ArrayList<>();
        this.customersInShop = new PriorityQueue<>();
    }

    public synchronized void enterCustomer(Customer customer) {
        notifyAll();
        listCustomers.add(customer);

    }

    public synchronized boolean validateChair(Customer customer) {
        notifyAll();
        if (customersInShop.size() >= numSeats) {
            customersWithOutHaircut.add(customer);
            return false;
        }
        return true;
    }

    public synchronized boolean getHaircut(Customer customer) {
        notifyAll();
        while (customersInShop.size() == numSeats) {
            listCustomerExit.add(customer);
            return false;
        }

        customersInShop.add(customer);
        System.out.println("Seats available: " + (numSeats - customersInShop.size()));

        while (customersInShop.contains(customer)) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll(); // wake the barber!
        // exit protocol
        while (!done) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        done = false;
        notifyAll();
        return true;
    }

    public synchronized void finishHaircut(Customer customer) {
        done = true;
        customer.setState(true);
        notifyAll();
        while (done) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
    }


    public synchronized Customer getNextCustomer() {
        notifyAll();
        while (customersInShop.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();

        Customer customer = customersInShop.poll();
        listCustomerExit.add(customer);
        return customer;
    }

    public synchronized int getNumSeats() {
        notifyAll();
        return numSeats - customersInShop.size();
    }

    public ArrayList<Customer> getListCustomersExit() {
//        notifyAll();
        return listCustomerExit;
    }

    public ArrayList<Customer> getListCustomers() {
//        notifyAll();
        return listCustomers;
    }

}
