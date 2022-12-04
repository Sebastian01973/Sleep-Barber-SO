package controllers;

import models.Barber;
import models.BarberShop;
import models.Customer;
import models.generator.NameGenerator;
import views.Constant;
import views.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Presenter implements ActionListener {

    private Window window;
    private BarberShop shop;
    private AtomicInteger timeShavingAt = new AtomicInteger();

    private Timer timer,timer2;
    private int counter = 0;
    private Thread thread;

    public Presenter() {
        this.window = new Window(this);
        window.setVisibleSplash(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())) {
            case B_EXIT -> System.exit(0);
            case START_SIMULATION -> {
//                timeSimulation();
                startSimulation();
                window.setVisibleSplash(false);
                window.setVisible(true);
            }
            case CLIENT_ATTENTION -> visibleClientAttention();
            case CLIENT_NO_ATTENTION -> visibleClientNoAttention();
            case STADISTICS -> visiblePieGraph();
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

    public void visiblePieGraph() {
        window.paintPie(shop.sizeList(shop.takeInfoCustomerExit()), shop.sizeList(shop.takeInfoCustomerNoAttended()));
        window.setVisibleStatistic(true);
    }

    private int generateRandomNumber(int time) {
        Random random = new Random();
        return random.nextInt(1, time);
    }

    public void timeSimulation() {
        //To do... Sofia
        String[] data = window.getDatesSimulation();
        int timeSimulation = Integer.parseInt(data[0]);
        AtomicInteger countTimeSimulaion = new AtomicInteger();
        System.out.println("Init Simulation: " + countTimeSimulaion);
        if (countTimeSimulaion.get() <= timeSimulation) {
            startSimulation();
            countTimeSimulaion.getAndIncrement();
            window.setTimeSimulation(countTimeSimulaion.get());
        }
        timer.stop();
        timer2.stop();
        thread.interrupt();
        System.out.println("Finalizo la simulacion");
    }


    private void startSimulation() {
        String[] data = window.getDatesSimulation();
        int timeSimulat = Integer.parseInt(data[0]);
        int numSeats = Integer.parseInt(data[1]);
        int timeNextCustomer = Integer.parseInt(data[2]);
        int timeShaving = Integer.parseInt(data[3]);

        shop = new BarberShop(numSeats);
        window.setMaxChairs(numSeats);
        Barber barber = new Barber("SOFIA BARBERA", timeShaving, shop);
        barber.start();

        thread = new Thread(() -> {
            while (true) {
                try {
                    int nextTimeRandom = generateRandomNumber(timeNextCustomer);
                    System.out.println("Random de numero: " + timeNextCustomer + " - Random: " + nextTimeRandom);
                    sleep(TimeUnit.SECONDS.toMillis(nextTimeRandom));
                    Customer customer = new Customer(counter, NameGenerator.generate(), generateRandomNumber(3), shop);
                    customer.start();
                    window.setPriorityCustomer(customer.getPriorityCustomer());
                    window.setIdCustomer(customer.getIdCustomer());
                    if (shop.isShopFull()) {
                        window.shopState(Constant.IMG_CLIENT_NO_SPACE);
                        sleep(500);
                        window.shopState(Constant.IMG_CLIENT_LEAVING);
                    } else window.shopState(Constant.IMG_CLIENT_ENTERING);
                    timeShavingAt.set(barber.getTimeShaving()); //S
                    counter++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        );
        thread.start();

        timer = new Timer((500), e -> {
            if (!shop.isBarberSleeping()) {
                if (timeShavingAt.get() > 0) window.setTimeAttentionBarber(timeShavingAt.getAndDecrement());
                else window.setTimeAttentionBarber(0);
                window.setStateBarber(Constant.IMG_HAIRCUT);
            } else {
                window.setTimeAttentionBarber(0);
                window.setStateBarber(Constant.IMG_SLEEP_BARBER);
                window.shopState(Constant.IMG_DOOR);
            }
        });
        timer.start();

        timer2 = new Timer((500), e -> {
            window.setAvailable(shop.getSeatsAvailable());
            window.setOccupiedChairs(shop.getOccupiedSeats());
            window.refreshTableCenter(shop.takeInfoCustomerShop());

            window.refreshTableAttentionClient(shop.takeInfoCustomerExit()); //Refreza la tabla de atencion al cliente
            window.refreshTableAttentionNoClient(shop.takeInfoCustomerNoAttended()); // Refresca la tabla de no atencion al cliente

        });
        timer2.start();
    }
}
