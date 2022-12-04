package views.main;

import models.Customer;
import views.Constant;
import views.models.JModelLabel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JTableCenter extends JPanel {

    private javax.swing.JTable jTable;
    private DefaultTableModel dtmElements;
    private JScrollPane jScrollPane;
    private String[] headers;

    private JModelLabel maxChairs, availableChairs, occupiedChairs;

    public JTableCenter(ActionListener actionListener) {
        dtmElements = new DefaultTableModel() {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }
        };
        dtmElements.setColumnIdentifiers(Constant.H_PRODUCTS);
        this.setLayout(new BorderLayout());
        initComponents(actionListener);
    }

    public void initHeaderTable() {
        JPanel headerTable = new JPanel();
        headerTable.setLayout(new FlowLayout(FlowLayout.CENTER));
        headerTable.setBackground(Constant.COLOR_WHITE);
        headerTable.setBorder(BorderFactory.createEmptyBorder(2, 0, 6, 0));

        maxChairs = new JModelLabel("Maximo Sillas: 1", Constant.FONT_ARIAL_ROUNDER_17, Constant.COLOR_WHITE, Constant.COLOR_BLACK);
        maxChairs.setColorPaint(Constant.COLOR_WHITE);
        maxChairs.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        headerTable.add(maxChairs);

        headerTable.add(Box.createRigidArea(new Dimension(20, 0)));

        occupiedChairs = new JModelLabel("Sillas Ocupadas: 1", Constant.FONT_ARIAL_ROUNDER_17, Constant.COLOR_WHITE, Constant.COLOR_BLACK);
        occupiedChairs.setColorPaint(Constant.COLOR_WHITE);
        occupiedChairs.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        headerTable.add(occupiedChairs);

        headerTable.add(Box.createRigidArea(new Dimension(20, 0)));

        availableChairs = new JModelLabel("Sillas Disponibles: 1", Constant.FONT_ARIAL_ROUNDER_17, Constant.COLOR_WHITE, Constant.COLOR_BLACK);
        availableChairs.setColorPaint(Constant.COLOR_WHITE);
        availableChairs.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        headerTable.add(availableChairs);

        this.add(headerTable, BorderLayout.NORTH);

    }

    private void initComponents(ActionListener actionListener) {
        initHeaderTable();
        jTable = new javax.swing.JTable();
        jTable.setModel(dtmElements);
        jTable.setIntercellSpacing(new Dimension(0, 0));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.getTableHeader().setBackground(Constant.COLOR_GRAY_LIGHT_1);
        jTable.getTableHeader().setForeground(Constant.COLOR_BLUE_DARK_2);
        jTable.getTableHeader().setPreferredSize(new Dimension(0, 50));
        jTable.getTableHeader().setFont(Constant.FONT_ARIAL_ROUNDER_17);
        jTable.getTableHeader().setResizingAllowed(false);
        jTable.setFont(Constant.FONT_ARIAL_ROUNDER_15);
        jTable.setBackground(Color.WHITE);
        jTable.setFillsViewportHeight(false);
        jTable.setRowHeight(35);
        jTable.setBorder(null);
        jTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jScrollPane = new JScrollPane(jTable);
        jScrollPane.setForeground(Color.white);
        jScrollPane.setBorder(null);
        jScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(jScrollPane, BorderLayout.CENTER);
        this.setBorder(null);
    }

    public void addRowTable(Object[] vector) {
        dtmElements.addRow(vector);
    }

    public void cleanRowsTable() {
        dtmElements.setNumRows(0);
    }

    private void centerText() {
        DefaultTableCellRenderer centeRenderer = new DefaultTableCellRenderer();
        centeRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            jTable.getColumnModel().getColumn(i).setCellRenderer(centeRenderer);
        }
    }

    public void addElementToTable(ArrayList<Object[]> matrix) {
        cleanRowsTable();
        dtmElements.setColumnIdentifiers(Constant.H_PRODUCTS);
        this.centerText();
//        UtilitiesViews.getModelColumn(jtElements, 0, 75, 75, 75);
//        UtilitiesViews.getModelColumn(jtElements, 2, 55, 55, 55);
        for (Object[] objects : matrix) {
            addElementToTable(objects, true);
        }
    }

    public void addElementToTable(Object[] vector, boolean status) {
        if (status) {
            dtmElements.addRow(vector);
        } else {
            dtmElements.addRow(vector);
        }
    }

    public void addRowsToTable(ArrayList<Object[]> matrix, String[] newHeaders) {
        cleanRowsTable();
        this.headers = newHeaders;
        dtmElements.setColumnIdentifiers(headers);
        this.centerText();
        for (Object[] objects : matrix) {
            addRowTable(objects);
        }
    }

    public int getColumnCountTable() {
        return jTable.getColumnCount();
    }

    public String getSelectedRow(Point point) {
        int selectedRow = jTable.rowAtPoint(point);
        return String.valueOf(jTable.getValueAt(selectedRow, 0));
    }

    public void setMaxChairs(int maxChairs) {
        this.maxChairs.setText("Maximo Sillas: " + maxChairs);
    }

    public void setAvailable(int availableChairs) {
        this.availableChairs.setText("Sillas Disponibles: " + availableChairs);
    }

    public void setOccupiedChairs(int noAvailableChairs) {
        this.occupiedChairs.setText("Sillas Ocupadas: " + noAvailableChairs);
    }
}
