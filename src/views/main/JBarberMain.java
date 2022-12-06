package views.main;

import views.Constant;
import views.models.JModelLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JBarberMain extends JPanel {


    JModelLabel stateBarber, labelStateBarber,titleBarber;
    JLabel timeAttention,idClient;


    public JBarberMain(ActionListener actionListener) {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Constant.COLOR_WHITE);
        this.setBorder(BorderFactory.createEmptyBorder(30,5,5,5));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {

        add(Box.createRigidArea(new Dimension(0,20)));

        titleBarber = new JModelLabel("Main Room",Constant.FONT_ARIAL_ROUNDER_20,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        titleBarber.setColorPaint(Constant.COLOR_WHITE);
        titleBarber.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.add(titleBarber);

        this.add(Box.createRigidArea(new Dimension(0,20)));


        stateBarber = new JModelLabel(Constant.IMG_SLEEP_BARBER);
        stateBarber.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.add(stateBarber);

        this.add(Box.createRigidArea(new Dimension(0,20)));

        labelStateBarber = new JModelLabel("Durmiendo",Constant.FONT_ARIAL_ROUNDER_20,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        labelStateBarber.setColorPaint(Constant.COLOR_WHITE);
        labelStateBarber.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.add(labelStateBarber);

        this.add(Box.createRigidArea(new Dimension(0,20)));
        idClient = new JLabel("");
        idClient.setFont(Constant.FONT_ARIAL_ROUNDER_20);
        idClient.setBackground(Constant.COLOR_WHITE);
        idClient.setForeground(Constant.COLOR_BLACK);
        idClient.setAlignmentX(LEFT_ALIGNMENT);
        this.add(idClient);

        timeAttention = new JLabel("");
        timeAttention.setFont(Constant.FONT_ARIAL_ROUNDER_20);
        timeAttention.setBackground(Constant.COLOR_WHITE);
        timeAttention.setForeground(Constant.COLOR_BLACK);
        timeAttention.setForeground(Constant.COLOR_BLACK);
        timeAttention.setAlignmentX(LEFT_ALIGNMENT);
        this.add(timeAttention);

        this.add(Box.createRigidArea(new Dimension(0,20)));
    }

    public void setIconBarber(String path){
        ImageIcon image;
        image = new ImageIcon(getClass().getResource(path));
        Icon icono = new ImageIcon(image.getImage().getScaledInstance(this.getWidth(), this.getHeight(), 1));
        stateBarber.setIcon(icono);
    }

    public void setTimeAttentionBarber(int time){
        if (time>0) timeAttention.setText("Tiempo corte: "+ time);
        else timeAttention.setText("");
    }

    public void setStateBarberLa1bel(String text){
        stateBarber.setText(text);
    }
    public void setIdClient(int id){
        if (id>=0)idClient.setText("Id Cliente: " +id);
        else idClient.setText("");
    }
    public void setStateBarber(String routeImg){
        stateBarber.setIconRelative(routeImg);
        if (routeImg.equals(Constant.IMG_HAIRCUT)) labelStateBarber.setText("Trabajando");
        else labelStateBarber.setText("Durmiendo");
    }
}
