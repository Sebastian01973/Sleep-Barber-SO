package views.models;

import javax.swing.*;
import java.awt.*;

public class LabelPieChart extends JLabel {
    private final int v1;
    private final int v2;
    private final String name;
    private final String name2;

    public LabelPieChart(int v1, int v2, String name,String name2) {
        this.v1 = v1;
        this.v2 = v2;
        this.name =name;
        this.name2=name2;
    }
    public void paint(Graphics g){
        new PieGraphic(g,v1,v2,name,name2);
    }
}
