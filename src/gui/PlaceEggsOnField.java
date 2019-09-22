package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class PlaceEggsOnField extends JFrame implements Serializable {

    private final Controller controller;

    public PlaceEggsOnField(Controller otherController) {
        controller = otherController;
        initialize();
    }

    private void initialize() {
        setBounds(100, 200, 500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        JLabel setX = new JLabel("Enter X coordinate:");
        setX.setBounds(80, 70, 170, 30);
        panel.add(setX);

        JTextField xCoord = new JTextField("");
        xCoord.setBounds(210, 70, 100, 30);
        xCoord.setHorizontalAlignment(JTextField.CENTER);
        xCoord.setBorder(border);
        panel.add(xCoord);

        JLabel setY = new JLabel("Enter Y coordinate:");
        setY.setBounds(80, 120, 200, 30);
        panel.add(setY);

        JTextField yCoord = new JTextField("");
        yCoord.setBounds(230, 120, 100, 30);
        yCoord.setHorizontalAlignment(JTextField.CENTER);
        yCoord.setBorder(border);
        panel.add(yCoord);

        JLabel eggValue = new JLabel("Enter egg value:");
        eggValue.setBounds(80, 25, 150, 30);
        panel.add(eggValue);

        JTextField eggValueText = new JTextField("");
        eggValueText.setBounds(200, 25, 100, 30);
        eggValueText.setHorizontalAlignment(JTextField.HORIZONTAL);
        eggValueText.setBorder(border);
        panel.add(eggValueText);

        JButton addPlayer = new JButton("Add EggItem on field");
        addPlayer.setBounds(170, 180, 200, 30);
        panel.add(addPlayer);
        addPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(xCoord.getText());
                int y = Integer.parseInt(yCoord.getText());
                int value = Integer.parseInt(eggValueText.getText());
                xCoord.setText("");
                yCoord.setText("");
                eggValueText.setText("");
                controller.addLifePoints(x, y, value);
            }
        });

        JButton next = new JButton("Start Game");
        next.setBounds(170, 220, 100, 30);
        panel.add(next);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.updateField();
                setVisible(false);
            }
        });
        add(panel);
    }
}
