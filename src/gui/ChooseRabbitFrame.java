package gui;

import javax.swing.*;
import java.io.Serializable;

public class ChooseRabbitFrame extends JFrame implements Serializable {

    public ChooseRabbitFrame(int rows, int columns, ParcelFrameRole[][] cell) {
        setBounds(100, 200, 500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel normalRabbit = new JLabel("Normal Rabbit");
        normalRabbit.setBounds(80, 70, 170, 30);
        panel.add(normalRabbit);

        RabbitButton rabbitButton = new RabbitButton("Normal Rabbit", rows, columns, cell);
        rabbitButton.setBounds(210, 70, 100, 30);
        rabbitButton.setHorizontalAlignment(JTextField.CENTER);
        panel.add(rabbitButton);

        JLabel rabbitWithHealth = new JLabel("Rabbit with health");
        rabbitWithHealth.setBounds(80, 120, 200, 30);
        panel.add(rabbitWithHealth);

        RabbitWithHealthButton rabbitWHButton = new RabbitWithHealthButton("RabbitWH", rows, columns, cell);
        rabbitWHButton.setBounds(230, 120, 100, 30);
        rabbitWHButton.setHorizontalAlignment(JTextField.CENTER);
        panel.add(rabbitWHButton);

        add(panel);
        setVisible(true);
    }


}
