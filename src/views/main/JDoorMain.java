package views.main;

import views.Constant;
import views.models.JModelLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDoorMain extends JPanel {


    JModelLabel tittleDoor,stateDoor, timeAttention, IdClient;

    public JDoorMain(ActionListener actionListener) {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Constant.COLOR_WHITE);
        this.setBorder(BorderFactory.createEmptyBorder(30,5,5,15));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {

        this.add(Box.createRigidArea(new Dimension(0,20)));

        tittleDoor = new JModelLabel("Entry Door",Constant.FONT_ARIAL_ROUNDER_20,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        tittleDoor.setColorPaint(Constant.COLOR_WHITE);
        tittleDoor.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.add(tittleDoor);

        this.add(Box.createRigidArea(new Dimension(0,30)));

        stateDoor = new JModelLabel(Constant.IMG_DOOR);
        stateDoor.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.add(stateDoor);

        this.add(Box.createRigidArea(new Dimension(0,20)));

        IdClient = new JModelLabel("",Constant.FONT_ARIAL_ROUNDER_20,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        IdClient.setColorPaint(Constant.COLOR_WHITE);
        IdClient.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.add(IdClient);

        this.add(Box.createRigidArea(new Dimension(0,20)));

        timeAttention = new JModelLabel("",Constant.FONT_ARIAL_ROUNDER_20,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        timeAttention.setColorPaint(Constant.COLOR_WHITE);
        timeAttention.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.add(timeAttention);

        this.add(Box.createRigidArea(new Dimension(0,20)));

    }
    public void setPriorityCustomer(int timeAtt){
       timeAttention.setText("Prioridad: " + timeAtt);
    }
    public void setIdCustomer(int idCustomer){
        IdClient.setText("ID: " + idCustomer);
    }
    public void shopState(String routeImg){
        stateDoor.setIconRelative(routeImg);
    }
}
