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
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(new Dimension((int) (Constant.SCREEN_SIZE.getWidth()*0.6),(int) (Constant.SCREEN_SIZE.getHeight()*0.6)));
        this.setMinimumSize(new Dimension((int) (Constant.SCREEN_SIZE.getWidth()*0.6),(int) (Constant.SCREEN_SIZE.getHeight()*0.6)));
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener){

        jDialogSplash = new JDialogSplash(listener,this);

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

}

