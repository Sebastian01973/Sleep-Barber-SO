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
        setSize(new Dimension(500, 350));
        this.setTitle("Estadisticas");
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(window);
        setModal(true);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        panelCenter = new JPanel();
        panelCenter.setBackground(Constant.COLOR_WHITE);
        panelCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelCenter.setLayout(new BorderLayout());
        this.add(panelCenter);

        titleAttention = new JModelLabel("Reporte de clientes antendidos y no antendidos", Constant.FONT_ARIAL_ROUNDER_17, Constant.COLOR_WHITE, Constant.COLOR_BLACK);
        titleAttention.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
        titleAttention.setColorPaint(Constant.COLOR_WHITE);
//        titleAttention.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        JPanel container = new JPanel();
        container.setBackground(Color.WHITE);
        container.add(titleAttention);
        panelCenter.add(container, BorderLayout.NORTH);

        pieGraphic = new LabelPieChart(1, 1, "", "");
        panelCenter.add(pieGraphic);
    }

    public void paintPie(int v1, int v2) {
        int total = (v1 + v2);
        int clienteAtendido = (v1 * 100) / total;
        int clienteNoAtendido = (v2 * 100) / total;
        panelCenter.remove(pieGraphic);
        pieGraphic = new LabelPieChart(v1, v2, "Clientes atendidos " + v1 + "  :  " + +clienteAtendido + " %", "Clientes no atendidos " + v2 + "  :  " + clienteNoAtendido + " %");
        pieGraphic.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        panelCenter.add(pieGraphic);
    }
}
