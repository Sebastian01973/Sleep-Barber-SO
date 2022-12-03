package views.main;

import controllers.Command;
import views.Constant;
import views.models.JModelButton;
import views.models.JModelLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JHeaderMain extends JPanel {

    private JModelLabel jLClient;
    private JModelButton jBClientAttention,jBClientNoAttention;
    private JModelButton stadistic;
    private JPanel panelLeft;

    public JHeaderMain(ActionListener actionListener) {
        this.setBackground(Constant.COLOR_BLUE_DARK_2);
        this.setLayout(new BorderLayout(0,0));
        this.setBorder(BorderFactory.createEmptyBorder(2,30,2,5));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        panelLeft = new JPanel();
        panelLeft.setBorder(BorderFactory.createEmptyBorder(10,5,10,0));
        panelLeft.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelLeft.setBackground(Constant.COLOR_BLUE_DARK_2);

        jLClient = new JModelLabel("Time Simulation: 10",Constant.FONT_ARIAL_ROUNDER_20,Constant.COLOR_BLUE_DARK_2,Constant.COLOR_WHITE);
        jLClient.setColorPaint(Constant.COLOR_BLUE_DARK_2);
        jLClient.setBackground(Constant.COLOR_BLUE_DARK_2);
        panelLeft.add(jLClient);

        this.add(panelLeft,BorderLayout.WEST);

        JPanel center = new JPanel();
        center.setLayout(new FlowLayout(FlowLayout.CENTER));
        center.setBackground(Constant.COLOR_BLUE_DARK_2);
        center.setBorder(BorderFactory.createEmptyBorder(2,0,6,0));

        jBClientAttention = new JModelButton("Clientes Atendidos",Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_BLUE_DARK_2,Constant.COLOR_WHITE);
        jBClientAttention.setColorPaint(Constant.COLOR_BLUE_DARK_2);
        jBClientAttention.setActionCommand(Command.CLIENT_ATTENTION.toString());
        jBClientAttention.addActionListener(actionListener);
        center.add(jBClientAttention);

        center.add(Box.createRigidArea(new Dimension(20, 0)));

        jBClientNoAttention = new JModelButton("Clientes No Atendidos",Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_BLUE_DARK_2,Constant.COLOR_WHITE);
        jBClientNoAttention.setColorPaint(Constant.COLOR_BLUE_DARK_2);
        jBClientNoAttention.setActionCommand(Command.CLIENT_NO_ATTENTION.toString());
        jBClientNoAttention.addActionListener(actionListener);
        center.add(jBClientNoAttention);

        center.add(Box.createRigidArea(new Dimension(20, 0)));

        stadistic = new JModelButton("Estadisticas",Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_BLUE_DARK_2,Constant.COLOR_WHITE);
        stadistic.setColorPaint(Constant.COLOR_BLUE_DARK_2);
        stadistic.setActionCommand(Command.STADISTICS.toString());
        stadistic.addActionListener(actionListener);
        center.add(stadistic);

        this.add(center,BorderLayout.CENTER);
    }

    public void setTimeSimulation(int time){
        jLClient.setText("Time Simulation: "+ time);
    }
}
