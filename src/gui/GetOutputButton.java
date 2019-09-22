package gui;

import game.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class GetOutputButton extends JButton implements Serializable, ActionListener {

    private Game game;

    public GetOutputButton(String text, Game otherGame) {
        addActionListener(this);
        this.game = otherGame;
        setText(text);
        setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String output = game.getOutput();
        JOptionPane.showMessageDialog(null, output, "Game Stats", JOptionPane.INFORMATION_MESSAGE);
    }

}
