package controllers;

import models.Barber;
import models.BarberShop;
import models.Customer;
import views.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Presenter implements ActionListener {

    private Window window;
    private BarberShop shop;

    public Presenter() {
        this.window = new Window(this);
        window.setVisibleSplash(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())) {
            case B_EXIT -> System.exit(0);
            case START_SIMULATION -> {
                startSimulation();
                window.setVisibleSplash(false);
                window.setVisible(true);
            }
            case CLIENT_ATTENTION -> visibleClientAttention();
            case CLIENT_NO_ATTENTION -> window.setVisibleClientNoAttention(true);
            case STADISTICS -> window.setVisibleStatistic(true);
            case CANCEL_DIALOG -> {
                window.setVisibleClientAttention(false);
                window.setVisibleClientNoAttention(false);
                window.setVisibleStatistic(false);
            }
        }
    }

    public void visibleClientAttention() {
        window.refreshTableAttentionClient(shop.takeInfoCustomerExit());
        window.setVisibleClientAttention(true);
    }

    public void getDatesSimulation() {

    }

    private int counter = 0;

    private void startSimulation() {
        String[] data = window.getDatesSimulation();
        int timeSimulation = Integer.parseInt(data[0]);
        int numSeats = Integer.parseInt(data[1]);
        int timeNextCustomer = Integer.parseInt(data[2]);
        int timeShaving = Integer.parseInt(data[3]);

        shop = new BarberShop(numSeats);
        window.setMaxChairs(numSeats);
        new Barber("SOFIA BARBERA", timeShaving, shop).start();
        new Thread(() -> {
            while (true) {
                try {
                    // PACHO CREE ESTO EN ALEATORIO
                    sleep(TimeUnit.SECONDS.toMillis(timeNextCustomer));
                    Customer customer = new Customer(counter, "Customer " + counter, (int) (Math.random() * 3 + 1),shop);
                    customer.start();
                    window.setTimeAttention(String.valueOf(customer.getTimeShaving()));

                    counter++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Timer timer = new Timer((int) TimeUnit.SECONDS.toMillis(1), e -> {
            window.refreshTableCenter(shop.takeInfoCustomerShop());
            if (!shop.isBarberSleeping()){
                window.setStateBarber();
            }else {

            }
        });

        timer.start();

    }


}
