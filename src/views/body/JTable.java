package views.body;

import java.awt.*;

public class JTable extends javax.swing.JTable {

    public JTable() {
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setPreferredSize(new Dimension(0, 30));
        setFillsViewportHeight(true);
        setRowHeight(35);
        setBorder(null);
        getTableHeader().setResizingAllowed(false);
        setIntercellSpacing(new Dimension(0, 0));
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setBackground(Color.WHITE);
        getTableHeader().setForeground(Color.BLUE);
        getTableHeader().setPreferredSize(new Dimension(0, 50));
//        getTableHeader().setFont(Constant.FONT_ARIAL_ROUNDER_17);
//        setFont(Constant.FONT_ARIAL_ROUNDER_15);
        setFillsViewportHeight(false);
        setBackground(Color.WHITE);
        setRowHeight( 35 );
    }

}
