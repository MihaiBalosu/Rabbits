package gui;

import controller.Controller;
import save_load.SaveLoad;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class StartGameFrame extends JFrame implements Serializable {

    private Controller controller;


    public StartGameFrame(Controller otherController) throws HeadlessException {
        this.controller = otherController;
        initialize();
    }

    private void initialize() {
        setBounds(100, 200, 500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        JLabel setNoOfRows = new JLabel("Enter number of rows:");
        setNoOfRows.setBounds(80, 70, 170, 30);
        panel.add(setNoOfRows);

        JTextField noOfRows = new JTextField("");
        noOfRows.setBounds(210, 70, 100, 30);
        noOfRows.setHorizontalAlignment(JTextField.CENTER);
        noOfRows.setBorder(border);

        noOfRows.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        panel.add(noOfRows);

        JLabel setNoOfColumns = new JLabel("Enter number of columns:");
        setNoOfColumns.setBounds(80, 120, 200, 30);
        panel.add(setNoOfColumns);

        JTextField noOfColumns = new JTextField("");
        noOfColumns.setBounds(230, 120, 100, 30);
        noOfColumns.setHorizontalAlignment(JTextField.CENTER);
        noOfColumns.setBorder(border);
        noOfColumns.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });

        panel.add(noOfColumns);

        JButton createGame = new JButton("Create");
        createGame.setBounds(170, 180, 110, 30);
        createGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                try {
                    controller.createFieldFrame();
                    int columns = Integer.parseInt(noOfColumns.getText());
                    int rows = Integer.parseInt(noOfRows.getText());
                    controller.createParcels(rows, columns);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        panel.add(createGame);

        SaveLoad load = new SaveLoad();
        JButton loadButton = new JButton("Load");
        loadButton.setBounds(200, 220, 110, 30);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FieldFrameBuilder gameFrame = load.load();
                    gameFrame.setVisible(true);
                    setVisible(false);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(loadButton);

        add(panel);

        setVisible(true);
    }

}
