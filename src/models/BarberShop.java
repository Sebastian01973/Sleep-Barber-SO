package models;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BarberShop {

    /**
     * Number of seats
     */
    private final int numSeats;

    /**
     * Quantity of seats number available.
     */
    private int numSeatsAvailable;

    /**
     * List of customers who are sitting in the store.
     */
    private final PriorityQueue<Customer> customersInShop;
    /**
     * List of customers who are in the store.
     */
    private final ArrayList<Customer> listCustomers;
    /**
     * List of customers who left the store.
     */
    private final ArrayList<Customer> listCustomerExit;

    private int occupiedSeats;
    private boolean done = false;

    /**
     * @param numSeats Number of chairs the store has.
     */
    public BarberShop(int numSeats) {
        this.numSeats = numSeats;
        this.listCustomers = new ArrayList<>();
        this.listCustomerExit = new ArrayList<>();
        this.customersInShop = new PriorityQueue<>();
        this.numSeatsAvailable = numSeats;
        this.occupiedSeats = 0;
    }

    /**
     * @param customer Add the customer to the list of customers entering the store.
     */
    public synchronized void enterCustomer(Customer customer) {
        notifyAll();
        listCustomers.add(customer);
    }

    /**
     * @param customer Customer who will be served in the store.
     * @return Returns true if the client was attacked successfully and false if the client was not attended.
     */
    public synchronized boolean getHaircut(Customer customer) {
        if (validateSeats(customer)) return false;
        while (customersInShop.contains(customer)) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll(); // wake up the barber!
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

    /**
     * @return Return quantity of seats available.
     */
    public synchronized int getSeatsAvailable() {
        notifyAll();
        return this.numSeatsAvailable;
    }

    /**
     * @return Return number of seats occupied.
     */
    public synchronized int getOccupiedSeats() {
        notifyAll();
        return occupiedSeats;
    }

    /**
     * @param customer Customer who is in the store.
     * @return Returns true if the number of chairs is equal to the number of users that are in the store.
     * @desciption In case the number of chairs in the store is equal to the number of chairs, the customer who entered leaves the store and is added to the list of exit users. Conversely, if the user can sit in a chair, the customer is added to the list of waiting users.
     */
    private boolean validateSeats(Customer customer) {
        notifyAll();
        if (customersInShop.size() == numSeats) {
            listCustomerExit.add(customer);
            return true;
        }
        customersInShop.add(customer);
        this.numSeatsAvailable = numSeats - customersInShop.size();
        this.occupiedSeats = customersInShop.size();
        return false;
    }

    /**
     * @param customer Customer who finished the cut in the store.
     * @desciption The method is for the customer output, so its status as a customer changes to true which means that their haircut was done correctly. Customer who finished the cut in the store.
     */
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

    /**
     * @return Returns the next customer to be served.
     * @desciption Through the priority list of clients, the first one on this list is obtained, but if there is no list of waiting clients, the barber sleeps.
     */
    public synchronized Customer getNextCustomer() {
        notifyAll();
        while (isSeatsEmpty()) {
            try {
                wait(); // Barber is sleeping.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
        Customer customer = customersInShop.poll();
        listCustomerExit.add(customer);
        return customer;
    }

    /**
     * @return Returns true if the seats are empty.
     */
    private boolean isSeatsEmpty() {
        return customersInShop.size() == 0;
    }

    public ArrayList<Customer> getListCustomersExit() {
        return listCustomerExit;
    }

    public ArrayList<Customer> getListCustomers() {
        return listCustomers;
    }





    // Info: IDCustomer, NameCustomer, Priority, TimeShaving.
    public Object[][] takeInfoCustomer(List<Customer> customer) {
        Object[][] matrix = new Object[customer.size()][];
        int c = matrix.length;
        for (int i = 0; i < c; i++) {
            matrix[i] = customer.get(i).getData();
        }
        return matrix;
    }

}

