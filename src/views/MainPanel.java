package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    JPanel jpTitle = new JPanel();
    public MainPanel(ActionListener listener){

        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);

        GridBagConstraints constraints = new GridBagConstraints();

        jpTitle.setLayout(new GridBagLayout());
//        jpTitle.setLayout(constraints);

        JLabel txAddCustomer = new JLabel("Add New Customer");
        txAddCustomer.setFont(new Font("Arial", Font.PLAIN, 14));
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        jpTitle.add(txAddCustomer, constraints);

        JButton buttonAddCustomer = new JButton("Add Customer");
        buttonAddCustomer.setActionCommand("AddCustomer");
        buttonAddCustomer.addActionListener(listener);
//        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 1;
//        constraints.insets = new Insets(0, 0, 0, 10);

        jpTitle.add(buttonAddCustomer, constraints);
//        this.add(jpCenter, BorderLayout.CENTER);

        JPanel jpTitleCenter = new JPanel();
        jpTitleCenter.setBackground(Color.decode("#36393f"));
        JLabel txTittle = new JLabel("Sleeping Barber");
        txTittle.setFont(new Font("Arial", Font.BOLD, 25));
        txTittle.setForeground(Color.WHITE);

//        jpTitleCenter.setLayout(new BorderLayout());
        jpTitleCenter.add(txTittle, BorderLayout.PAGE_START);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = 40;
        constraints.weightx = 0.0;
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 0;
        jpTitle.add(jpTitleCenter, constraints);

        this.add(jpTitle, BorderLayout.NORTH);

        JButton buttonListCustomers = new JButton("ListCustomers");
        buttonListCustomers.setActionCommand("ListCustomers");
        buttonListCustomers.addActionListener(listener);
        this.add(buttonListCustomers, BorderLayout.SOUTH);

    }

    public String getNameCustomer() {
        return "";
    }
}
