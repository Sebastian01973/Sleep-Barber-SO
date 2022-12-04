package views.splash;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDialogSplash extends JDialog {

    private ImageSplash imageSplash;
    private JMainSplash jMainSplash;
    private JPanel jContainerPanel;


    public JDialogSplash(ActionListener actionListener, Window window) {
        setSize(new Dimension(700,470));
        setModal(true);
        setUndecorated(true);
        this.setLocationRelativeTo(window);
        iniComponents(actionListener);
    }

    private void iniComponents(ActionListener actionListener) {
        jContainerPanel = new JPanel();
        jContainerPanel.setLayout(new GridLayout(0,2));
        jContainerPanel.setBackground(new Color(33, 44, 63));
        jContainerPanel.setBorder(null);

        imageSplash = new ImageSplash(actionListener);
        jContainerPanel.add(imageSplash);

        jMainSplash = new JMainSplash(actionListener);
        jContainerPanel.add(jMainSplash);

        this.add(jContainerPanel);
    }
    public String[] getDatesSimulation(){
        return jMainSplash.getDatesSimulation();
    }

}
