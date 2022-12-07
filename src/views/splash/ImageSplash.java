package views.splash;

import controllers.Command;
import views.Constant;
import views.models.JModelLabel;
import views.models.RoundedJButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ImageSplash extends JPanel {

    RoundedJButton exitButton;

    public ImageSplash(ActionListener actionListener) {
        setLayout(null);
        setBackground(Color.BLACK);
        exitButton = new RoundedJButton(Constant.EXIT, Command.B_EXIT.toString(), actionListener,Constant.COLOR_ORANGE_2,Color.white);
        exitButton.setBounds(20,430,80,25);
        add(exitButton);
    }
   @Override
    public void paint(Graphics g) {
        setOpaque(false);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(new ImageIcon(getClass().getResource("/sleep.gif")).getImage(),0,0,getWidth(),getHeight(),this);
        super.paint(g);
    }
}
