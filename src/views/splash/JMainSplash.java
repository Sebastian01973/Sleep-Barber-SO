package views.splash;

import controllers.Command;
import views.Constant;
import views.models.RoundedJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatter;
import java.awt.*;
import java.awt.event.ActionListener;

public class JMainSplash extends JPanel {

    //Tiempo de simulacion, Numero de sillas,
    JLabel title;
    JSpinner timeSimulation, numSteps,timeMaxAttention,timeNextClient;
    RoundedJButton startSimulation;


    public JMainSplash(ActionListener actionListener) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(5,30,38,30));
        setBackground(Color.WHITE);

        add(Box.createRigidArea(new Dimension(0, 70)));

        title = new JLabel(Constant.T_SIMULATOR);
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setForeground(Constant.COLOR_BLACK);
        title.setFont(Constant.FONT_ARIAL_ROUNDER_25_B);
        this.add(title);

        JLabel name = new JLabel("Barbero Dormilon");
        name.setAlignmentX(CENTER_ALIGNMENT);
        name.setForeground(Constant.COLOR_BLACK);
        name.setFont(Constant.FONT_ARIAL_ROUNDER_25_B);
        this.add(name);

        add(Box.createRigidArea(new Dimension(0, 20)));

        timeSimulation = new JSpinner(new SpinnerNumberModel(100, 1, 300, 1));
        ((DefaultFormatter) ((JSpinner.NumberEditor)timeSimulation.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        timeSimulation.setBorder(BorderFactory.createTitledBorder("Tiempo de Simulacion (Segundos)"));
        timeSimulation.setBackground(Constant.COLOR_WHITE);
        this.add(timeSimulation);


        add(Box.createRigidArea(new Dimension(0, 20)));

        numSteps = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));
        ((DefaultFormatter) ((JSpinner.NumberEditor)numSteps.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        numSteps.setBorder(BorderFactory.createTitledBorder("Numero de Sillas"));
        numSteps.setBackground(Constant.COLOR_WHITE);
        this.add(numSteps);

        add(Box.createRigidArea(new Dimension(0, 20)));

        timeNextClient = new JSpinner(new SpinnerNumberModel(2, 2, 50, 1));
        ((DefaultFormatter) ((JSpinner.NumberEditor)numSteps.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        timeNextClient.setBorder(BorderFactory.createTitledBorder("Tiempo maximo que llegue proximo cliente"));
        timeNextClient.setBackground(Constant.COLOR_WHITE);
        this.add(timeNextClient);

        add(Box.createRigidArea(new Dimension(0, 20)));

        timeMaxAttention = new JSpinner(new SpinnerNumberModel(2, 2, 50, 1));
        ((DefaultFormatter) ((JSpinner.NumberEditor)numSteps.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        timeMaxAttention.setBorder(BorderFactory.createTitledBorder("Tiempo maximo para atender un cliente"));
        timeMaxAttention.setBackground(Constant.COLOR_WHITE);
        this.add(timeMaxAttention);

        add(Box.createRigidArea(new Dimension(0, 30)));

        startSimulation = new RoundedJButton("Iniciar Simulacion", Command.START_SIMULATION.toString(), actionListener, Constant.BLUE,Color.WHITE);
        startSimulation.setFont(Constant.FONT_ARIAL_ROUNDER_15);
        startSimulation.setAlignmentX(CENTER_ALIGNMENT);
        add(startSimulation);

    }

    public String[] getDatesSimulation(){
      return new String[]{
              String.valueOf(timeSimulation.getValue()),
              String.valueOf(numSteps.getValue()),
              String.valueOf(timeNextClient.getValue()),
              String.valueOf(timeMaxAttention.getValue())
      };
    }

}
