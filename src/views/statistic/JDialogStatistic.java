package views.statistic;

import views.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDialogStatistic extends JDialog {
    public JDialogStatistic(ActionListener listener, Window window) {
        setSize(new Dimension(900,500));
        this.setTitle("Estadisticas");
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(window);
        setModal(true);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {

    }
}
