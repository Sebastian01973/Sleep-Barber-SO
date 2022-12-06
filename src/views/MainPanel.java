package views;

import models.Customer;
import views.main.JBarberMain;
import views.main.JTableCenter;
import views.main.JDoorMain;
import views.main.JHeaderMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    public void setTimeSimulation(int time){
        jHeaderMain.setTimeSimulation(time);
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

    public void setMaxChairs(int maxChairs) {
        jTableCenter.setMaxChairs(maxChairs);
    }


    public void addElementToTable(ArrayList<Object[]> matrix) {
        jTableCenter.addElementToTable(matrix);
    }

    public void setStateBarber(String routeImg){
        jBarberMain.setStateBarber(routeImg);
    }
    public void setPriorityCustomer(int timeAtt){
        jDoorMain.setPriorityCustomer(timeAtt);
    }
    public void setIdCustomer(int idCustomer){
        jDoorMain.setIdCustomer(idCustomer);
    }
    public void setAvailable(int availableChairs) {
        jTableCenter.setAvailable(availableChairs);
    }
    public void shopState(String routeImg){
        jDoorMain.shopState(routeImg);
    }
    public void setOccupiedChairs(int noAvailableChairs){
        jTableCenter.setOccupiedChairs(noAvailableChairs);
    }
    public void setIdClient(int id){
        jBarberMain.setIdClient(id);
    }
}
