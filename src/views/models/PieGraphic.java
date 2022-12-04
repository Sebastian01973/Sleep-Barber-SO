package views.models;

import views.Constant;

import java.awt.*;

public class PieGraphic{
    private final Color color1;
    public PieGraphic(Graphics g, double v1, double v2, String name1, String name2){
        color1 = Constant.COLOR_BLUE_LIGHT_1;
        double sum = v1+v2;
        int degree1 = (int) (v1 * 360/sum);
        int degree2 = (int) (v2 * 360/sum);

        g.setColor(color1);
        g.fillArc(0,0,200,200,0,degree1);
        g.fillRect(210,30,20,20);
        g.drawString(name1, 240,45);

        g.setColor(Constant.COLOR_ORANGE_1);
        g.fillArc(0,0,200,200,degree1,degree2);
        g.fillRect(210,60,20,20);
        g.drawString(name2, 240,75);
    }
}
