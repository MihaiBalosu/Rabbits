package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class RestartButton extends JButton implements Serializable, ActionListener {
    private FieldFrameBuilder frame;
    private Controller controller;


    public RestartButton(String name, Controller otherController, FieldFrameBuilder otherFieldFrameBuilder) {
        addActionListener(this);
        setText(name);
        this.controller = otherController;
        this.frame = otherFieldFrameBuilder;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        controller.restart();
    }

}
