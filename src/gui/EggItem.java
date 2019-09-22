package gui;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;

public class EggItem extends JFrame implements ItemTypeRole, Serializable {
    private int value;
    private int x;
    private int y;

    @Override
    public void doAction(int otherX, int otherY, Controller controller) {
        this.x = otherX;
        this.y = otherY;
        setBounds(100, 200, 400, 225);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        JLabel setNoOfRows = new JLabel("Enter egg value:");
        setNoOfRows.setBounds(80, 70, 150, 30);
        panel.add(setNoOfRows);

        JTextField valueText = new JTextField("");
        valueText.setBounds(200, 70, 100, 30);
        valueText.setHorizontalAlignment(JTextField.CENTER);
        valueText.setBorder(border);
        valueText.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });

        panel.add(valueText);

        JButton confirm = new JButton("Confirm");
        confirm.setBounds(150, 130, 110, 30);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = Integer.parseInt(valueText.getText());
                controller.addEgg(x, y, value);
                valueText.setText("");
                setVisible(false);
            }
        });

        panel.add(confirm);

        add(panel);
        setVisible(true);
    }
}
