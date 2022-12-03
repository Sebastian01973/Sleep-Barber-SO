package views.statistic;

import controllers.Command;
import views.Constant;
import views.Window;
import views.models.JModelButton;
import views.models.JModelLabel;
import views.models.RoundedJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientAttention extends JDialog {


    private JModelLabel titleAttention;
    private RoundedJButton buttonCancel;
    private JPanel panelCenter;
    private JTableModel jTableModel;


    public ClientAttention(ActionListener listener, Window window) {
        setUndecorated(true);
        setSize(new Dimension(900,500));
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(window);
        setModal(true);
        initComponents(listener);
    }

    private void initComponents(ActionListener actionListener) {
        panelCenter  = new JPanel();
        panelCenter.setBackground(Constant.COLOR_WHITE);
        panelCenter.setBorder(new EmptyBorder(5,5,5,5));
        panelCenter.setLayout(new BorderLayout());

        titleAttention = new JModelLabel("Clientes Atendidos",Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        titleAttention.setColorPaint(Constant.COLOR_WHITE);
        titleAttention.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        panelCenter.add(titleAttention,BorderLayout.NORTH);

        //Table
        jTableModel = new JTableModel();
        panelCenter.add(jTableModel,BorderLayout.CENTER);

        buttonCancel = new RoundedJButton("Cancelar", Command.CANCEL_DIALOG.toString(), actionListener, Constant.COLOR_RED_LIGHT_1,Color.WHITE);
        buttonCancel.setFont(Constant.FONT_ARIAL_ROUNDER_15);
        buttonCancel.setAlignmentX(CENTER_ALIGNMENT);
        panelCenter.add(buttonCancel,BorderLayout.SOUTH);

        this.add(panelCenter);
    }

    public void addRowTableAttentionClient(Object[] vector){
        jTableModel.addRowTable(vector);
    }

    public void refreshTableAttentionClient(ArrayList<Object[]> matrix){
        jTableModel.addElementToTable(matrix);
    }

}
