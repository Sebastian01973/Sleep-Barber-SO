package views;

import models.Customer;
import views.models.LabelPieChart;
import views.splash.JDialogSplash;
import views.statistic.ClientAttention;
import views.statistic.ClientNoAttention;
import views.statistic.JDialogStatistic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame {

    private MainPanel mainPanel;
    private JDialogSplash jDialogSplash;
    private ClientAttention clientAttention;
    private ClientNoAttention clientNoAttention;
    private JDialogStatistic jDialogStatistic;

    public Window(ActionListener listener) {
        this.setIconImage( new ImageIcon(getClass().getResource( Constant.IMG_LOGO)).getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle( Constant.TITLE_STORE);
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(new Dimension((int) (Constant.SCREEN_SIZE.getWidth()*0.7),(int) (Constant.SCREEN_SIZE.getHeight()*0.7)));
        this.setMinimumSize(new Dimension((int) (Constant.SCREEN_SIZE.getWidth()*0.7),(int) (Constant.SCREEN_SIZE.getHeight()*0.7)));
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener){

        jDialogSplash = new JDialogSplash(listener,this);
        jDialogStatistic = new JDialogStatistic(listener,this);
        clientAttention = new ClientAttention(listener,this);
        clientNoAttention = new ClientNoAttention(listener,this);

        mainPanel = new MainPanel(listener);
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
    }


    public void setVisibleSplash(boolean active){
        this.jDialogSplash.setVisible(active);
    }

    public String[] getDatesSimulation(){
        return jDialogSplash.getDatesSimulation();
    }

    public void setIconBarber(String path){
        mainPanel.setIconBarber(path);
    }

    public void setTimeAttentionBarber(int time){
        mainPanel.setTimeAttentionBarber(time);
    }

    public void setStateBarberLa1bel(String text){
        mainPanel.setStateBarberLa1bel(text);
    }

    public void setVisibleClientAttention(boolean status){
        clientAttention.setVisible(status);
    }
    public void setVisibleClientNoAttention(boolean status){
        clientNoAttention.setVisible(status);
    }

    public void setVisibleStatistic(boolean status){
        jDialogStatistic.setVisible(status);
    }

    public void setTimeSimulation(int time){
        mainPanel.setTimeSimulation(time);
    }


    public void addRowTableAttentionClient(Object[] vector){
        clientAttention.addRowTableAttentionClient(vector);
    }
    public void refreshTableAttentionClient(ArrayList<Object[]> matrix){
        clientAttention.refreshTableAttentionClient(matrix);
    }

    public void addRowTableAttentionNoClient(Object[] vector){
        clientNoAttention.addRowTableAttentionNoClient(vector);
    }

    public void refreshTableAttentionNoClient(ArrayList<Object[]> matrix){
        clientNoAttention.refreshTableAttentionNoClient(matrix);
    }

    public void setMaxChairs(int maxChairs) {
        mainPanel.setMaxChairs(maxChairs);
    }

    public void refreshTableCenter(ArrayList<Object[]> matrix){
        mainPanel.addElementToTable(matrix);
    }
    public void setStateBarber(String routeImg){
        mainPanel.setStateBarber(routeImg);
    }
    public void setPriorityCustomer(int timeAtt){
        mainPanel.setPriorityCustomer(timeAtt);
    }
    public void setIdCustomer(int idCustomer){
        mainPanel.setIdCustomer(idCustomer);
    }
    public void setAvailable(int availableChairs) {
        mainPanel.setAvailable(availableChairs);
    }
    public void shopState(String routeImg){
        mainPanel.shopState(routeImg);
    }
    public void setOccupiedChairs(int noAvailableChairs){
        mainPanel.setOccupiedChairs(noAvailableChairs);
    }
    public void paintPie(int v1, int v2){
        jDialogStatistic.paintPie(v1,v2);
    }
    public void setIdClient(int id){
        mainPanel.setIdClient(id);
    }
    }

