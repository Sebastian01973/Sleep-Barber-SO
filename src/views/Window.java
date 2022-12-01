package views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private MainPanel mainPanel;
    public Window(ActionListener listener) {
        this.setIconImage( new ImageIcon(getClass().getResource( Constant.IMG_LOGO)).getImage());
        this.setTitle( Constant.TITLE_STORE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setMinimumSize(Constant.SCREEN_SIZE);
        initComponents(listener);
        this.setVisible(true);
    }

    public void initComponents(ActionListener listener){
        mainPanel = new MainPanel(listener);
        add(mainPanel);
    }

    public String getNameCustomer(){
        return mainPanel.getNameCustomer();
    }

}

