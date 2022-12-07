package models;

public class Customer extends Thread implements Comparable<Customer> {

    /**
     * Specifies the primary key of the customer entity.
     */
    private final int id;

    /**
     * Specifies the priority of the customer entity.
     */
    private final int priority;

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
    private int timeShaving;

    public Customer(int id, String name, int priority, BarberShop shop) {
        this.id = id;
        this.priority = priority;
        this.name = name;
        this.shop = shop;
        this.timeShaving = 0;
    }

    public void run() {
        enterToShop();
        this.state = shop.getHaircut(this);
        exit(this.state);
    }

    /**
     * @description: Function for a customer enter the shop.
     */
    private void enterToShop() {
        shop.enterCustomer(this);
        System.out.println(this.name + " entered the shop! With priority: " + this.priority);
    }

    /**
     * @param result Specifies if the customer was served or not.
     * @description: Function for a customer exit the shop.
     */
    private void exit(boolean result) {
        System.out.println(this.name + " exited the shop " + (result ? "WITH haircut" : "WITHOUT haircut"));
    }

    /**
     * @return Returns the priority of the customer.
     */
    public int getPriorityCustomer() {
        return this.priority;
    }

    /**
     * @param state Specifies the state of the customer.
     * @description: Function for set the state of the customer.
     */
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
     * @return Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Customer customer) {
        return Integer.compare(this.getPriorityCustomer(), customer.getPriorityCustomer());
    }

    public int getTimeShaving() {
        return this.timeShaving;
    }

    public void setTimeShaving(int timeShaving) {
        this.timeShaving = timeShaving;
    }

    public Object[] getData() {
        return (new Object[]{this.getIdCustomer(), this.getNameCustomer(), this.getPriorityCustomer(), this.getTimeShaving()});
    }

    public Object[] getDataShop(){
        return (new Object[]{this.getIdCustomer(), this.getNameCustomer(), this.getPriorityCustomer()});
    }
}
