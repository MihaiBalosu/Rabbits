package gui;

import controller.Controller;
import game.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class StartTurnButton extends JButton implements ActionListener, Serializable {

    private Game game;
    private Controller controller;
    private JButton getOutputButton;

    public StartTurnButton(String name, Game otherGame, Controller otherController, GetOutputButton otherGetOutputButton) {
        addActionListener(this);
        setText(name);
        this.getOutputButton = otherGetOutputButton;
        this.game = otherGame;
        this.controller = otherController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.updateField();
        controller.playTurn();
        controller.updateInfoTable();

        if (game.isPlayable()) {
            getOutputButton.setEnabled(false);
            setEnabled(true);
        } else {
            getOutputButton.setEnabled(true);
            setEnabled(false);
        }
    }


}
