package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlacePlayersOnField extends JFrame {

    private final Controller controller;

    public PlacePlayersOnField(Controller otherController) {
        this.controller = otherController;
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

        JButton addPlayer = new JButton("Add rabbit on field");
        addPlayer.setBounds(170, 180, 200, 30);
        panel.add(addPlayer);
        addPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(xCoord.getText());
                int y = Integer.parseInt(yCoord.getText());
                xCoord.setText("");
                yCoord.setText("");
                controller.addPlayer(x, y);
            }
        });

        JButton next = new JButton("Next");
        next.setBounds(170, 220, 100, 30);
        panel.add(next);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                PlaceEggsOnField addEggsFrame = new PlaceEggsOnField(controller);
                addEggsFrame.setVisible(true);
            }
        });


        add(panel);
    }
}
