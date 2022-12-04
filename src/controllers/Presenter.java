package controllers;

import models.Barber;
import models.BarberShop;
import models.Customer;
import views.Constant;
import views.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Presenter implements ActionListener {

    private Window window;
    private BarberShop shop;
    AtomicInteger timeShavingAt = new AtomicInteger();

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
            case CLIENT_NO_ATTENTION -> visibleClientNoAttention();
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
    public void visibleClientNoAttention() {
        window.refreshTableAttentionNoClient(shop.takeInfoCustomerNoAttended());
        window.setVisibleClientNoAttention(true);
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
        Barber barber = new Barber("SOFIA BARBERA", timeShaving, shop);
        barber.start();
        new Thread(() -> {
            while (true) {
                try {
                    // PACHO CREE ESTO EN ALEATORIO
                    sleep(TimeUnit.SECONDS.toMillis(timeNextCustomer));
                    Customer customer = new Customer(counter, "Customer " + counter, (int) (Math.random() * 3 + 1),shop);
                    customer.start();
                    window.setPriorityCustomer(customer.getPriorityCustomer());
                    window.setIdCustomer(customer.getIdCustomer());
                    if (shop.isShopFull()) {
                        window.shopState(Constant.IMG_CLIENT_NO_SPACE);
                        sleep(500);
                        window.shopState(Constant.IMG_CLIENT_LEAVING);
                    }
                    else window.shopState(Constant.IMG_CLIENT_ENTERING);
                    timeShavingAt.set(barber.getTimeShaving());
                    counter++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Timer timer = new Timer((500), e -> {
            if(!shop.isBarberSleeping()) {
                if (timeShavingAt.get()>0) window.setTimeAttentionBarber(timeShavingAt.getAndDecrement());
                else window.setTimeAttentionBarber(0);
                window.setStateBarber(Constant.IMG_HAIRCUT);
            }
            else {
                window.setTimeAttentionBarber(0);
                window.setStateBarber(Constant.IMG_SLEEP_BARBER);
            }
        });
        timer.start();
        Timer timer2 = new Timer((200), e -> {
           window.setAvailable(shop.getSeatsAvailable());
           window.setOccupiedChairs(shop.getOccupiedSeats());
           window.refreshTableCenter(shop.takeInfoCustomerShop());
        });
        timer2.start();
    }


}
