package gui;

import javax.swing.*;
import java.io.Serializable;

public class ChoosePrizeFrame extends JFrame implements Serializable {

    public ChoosePrizeFrame(int rows, int columns, ParcelFrameRole[][] cell) {
        setBounds(200, 300, 500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel egg = new JLabel("Egg");
        egg.setBounds(80, 50, 170, 30);
        panel.add(egg);

        EggButton eggButton = new EggButton("Egg", cell, rows, columns);
        eggButton.setBounds(210, 50, 100, 30);
        eggButton.setHorizontalAlignment(JTextField.CENTER);
        panel.add(eggButton);

        JLabel lifes = new JLabel("Lifes");
        lifes.setBounds(80, 100, 200, 30);
        panel.add(lifes);

        LifesButton lifesButton = new LifesButton("Lifes", cell, columns, rows);
        lifesButton.setBounds(230, 100, 100, 30);
        lifesButton.setHorizontalAlignment(JTextField.CENTER);
        panel.add(lifesButton);

        JLabel trap = new JLabel("Trap");
        trap.setBounds(80, 150, 200, 30);
        panel.add(trap);

        TrapButton trapButton = new TrapButton("Trap", cell, rows, columns);
        trapButton.setBounds(230, 150, 100, 30);
        trapButton.setHorizontalAlignment(JTextField.CENTER);
        panel.add(trapButton);

        JLabel randomPrize = new JLabel("RandomPrize");
        randomPrize.setBounds(80, 200, 200, 30);
        panel.add(randomPrize);

        RandomPrizeButton randomPrizeButton = new RandomPrizeButton("Random Prize", cell, rows, columns);
        randomPrizeButton.setBounds(230, 200, 150, 30);
        randomPrizeButton.setHorizontalAlignment(JTextField.CENTER);
        panel.add(randomPrizeButton);

        JLabel carrotPrize = new JLabel("Carrot");
        carrotPrize.setBounds(80, 250, 200, 30);
        panel.add(carrotPrize);

        CarrotButton carrotPrizeButton = new CarrotButton("Carrot", cell, rows, columns);
        carrotPrizeButton.setBounds(230, 250, 150, 30);
        carrotPrizeButton.setHorizontalAlignment(JTextField.CENTER);
        panel.add(carrotPrizeButton);
        

        add(panel);
        setVisible(true);
    }

}
