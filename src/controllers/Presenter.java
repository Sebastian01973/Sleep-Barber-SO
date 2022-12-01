package controllers;

import models.Barber;
import models.BarberShop;
import views.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {

    private Window view;
    private BarberShop shop;

    public Presenter() {
        this.view = new Window(this);
        shop = new BarberShop(4);
        new Barber("JUAN", shop).start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())) {

        }
    }

}
