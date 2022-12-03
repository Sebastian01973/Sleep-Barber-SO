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
        new Barber("JUAN", shop).start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())) {
            case B_EXIT -> System.exit(0);
            case START_SIMULATION -> {window.setVisibleSplash(false); window.setVisible(true); }
            case CLIENT_ATTENTION -> openTableAttention();
            case CLIENT_NO_ATTENTION -> openTableNoAttention();
            case STADISTICS -> openDialogStatistic();
            case CANCEL_DIALOG -> {
                window.setVisibleClientAttention(false);
                window.setVisibleClientNoAttention(false);
                window.setVisibleStatistic(false);
            }
        }
    }

    private void openDialogStatistic() {
    }

    private void openTableNoAttention() {
    }

    private void openTableAttention() {
        window.setVisibleClientAttention(true);
    }

}
