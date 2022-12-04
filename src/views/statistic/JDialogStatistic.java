package views.statistic;

import views.Constant;
import views.Window;
import views.models.JModelLabel;
import views.models.LabelPieChart;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDialogStatistic extends JDialog {
    private LabelPieChart pieGraphic;
    private JModelLabel titleAttention;
    private JPanel panelCenter;
    public JDialogStatistic(ActionListener listener, Window window) {
        this.setBackground(Constant.COLOR_WHITE);
        setSize(new Dimension(800,500));
        this.setTitle("Estadisticas");
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(window);
        setModal(true);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        panelCenter  = new JPanel();
        panelCenter.setBackground(Constant.COLOR_WHITE);
        panelCenter.setBorder(new EmptyBorder(5,5,5,5));
        panelCenter.setLayout(new BorderLayout());
        this.add(panelCenter);

        titleAttention = new JModelLabel("Estadisticas",Constant.FONT_ARIAL_ROUNDER_17,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
        titleAttention.setColorPaint(Constant.COLOR_WHITE);
        titleAttention.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        panelCenter.add(titleAttention,BorderLayout.NORTH);

        pieGraphic = new LabelPieChart(1,1,"","");
        panelCenter.add(pieGraphic);
    }
    public void paintPie(int v1, int v2){
        panelCenter.remove(pieGraphic);
        pieGraphic = new LabelPieChart(v1,v2,"Clientes atendidos: " + v1,"Clientes no atendidos: " +v2);
        pieGraphic.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));
        panelCenter.add(pieGraphic);
    }
}
