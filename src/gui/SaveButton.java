package gui;

import save_load.SaveLoad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class SaveButton extends JButton implements ActionListener, Serializable {

    private FieldFrameBuilder gameView;


    public SaveButton(String name, FieldFrameBuilder otherGameView) {
        addActionListener(this);
        setText(name);
        this.gameView = otherGameView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SaveLoad save = new SaveLoad();
        save.save(gameView);
    }

}
