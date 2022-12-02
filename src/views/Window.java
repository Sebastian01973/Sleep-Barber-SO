package views;

import views.splash.JDialogSplash;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private MainPanel mainPanel;
    private JDialogSplash jDialogSplash;

    public Window(ActionListener listener) {
        this.setIconImage( new ImageIcon(getClass().getResource( Constant.IMG_LOGO)).getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle( Constant.TITLE_STORE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setMinimumSize(Constant.SCREEN_SIZE);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener){

        jDialogSplash = new JDialogSplash(listener,this);

        mainPanel = new MainPanel(listener);
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    public String getNameCustomer(){
        return mainPanel.getNameCustomer();
    }

    public void setVisibleSplash(boolean active){
        this.jDialogSplash.setVisible(active);
    }

    public String[] getDatesSimulation(){
        return jDialogSplash.getDatesSimulation();
    }

}

