package views;

import views.barber.JBarberMain;
import views.body.JTableCenter;
import views.door.JDoorMain;
import views.header.JHeaderMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    private JTableCenter jTableCenter;
    private JHeaderMain jHeaderMain;
    private JDoorMain jDoorMain;
    private JBarberMain jBarberMain;

    public MainPanel(ActionListener actionListener) {
        this.setBackground(Constant.COLOR_WHITE);
        this.setLayout(new BorderLayout());
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {

        jHeaderMain = new JHeaderMain(actionListener);
        this.add(jHeaderMain,BorderLayout.NORTH);

        jTableCenter = new JTableCenter(actionListener);
        this.add(jTableCenter,BorderLayout.CENTER);

        jDoorMain = new JDoorMain(actionListener);
        this.add(jDoorMain,BorderLayout.EAST);

        jBarberMain = new JBarberMain(actionListener);
        this.add(jBarberMain,BorderLayout.WEST);

    }


    public void setIconBarber(String path){
        jBarberMain.setIconBarber(path);
    }

    public void setTimeAttentionBarber(int time){
       jBarberMain.setTimeAttentionBarber(time);
    }

    public void setStateBarberLa1bel(String text){
        jBarberMain.setStateBarberLa1bel(text);
    }


}
