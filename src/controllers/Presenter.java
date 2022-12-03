package controllers;

import models.Barber;
import models.BarberShop;
import views.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {

    private Window window;
    private BarberShop shop;

    public Presenter() {
        this.window = new Window(this);
        window.setVisibleSplash(true);
        shop = new BarberShop(4);
        new Barber("JUAN", 4,shop).start();
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
            case CLIENT_ATTENTION -> window.setVisibleClientAttention(true);
            case CLIENT_NO_ATTENTION -> window.setVisibleClientNoAttention(true);
            case STADISTICS -> window.setVisibleStatistic(true);
            case CANCEL_DIALOG -> {
                window.setVisibleClientAttention(false);
                window.setVisibleClientNoAttention(false);
                window.setVisibleStatistic(false);
            }
        }
    }

    public void getDatesSimulation(){

    }

    private void startSimulation() {

        //Donde va toda la simulacion
    }

}
