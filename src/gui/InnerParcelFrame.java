package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class InnerParcelFrame extends JButton implements ParcelFrameRole, ParcelFrameActionRole, ActionListener, Serializable {


    private int x;
    private int y;
    private Controller controller;
    private ItemTypeRole itemType;

    public InnerParcelFrame() {
        setBackground(Color.white);
        this.addActionListener(this);
    }

    @Override
    public void addPlayer(Color color, int index) {
        setBackground(color);
        setText("R" + index);
    }

    @Override
    public void addEggInGUI(int value) {
        setBackground(Color.PINK);
        setText("E" + value);
    }

    @Override
    public void setItemType(ItemTypeRole itemType) {
        this.itemType = itemType;
    }

    @Override
    public void addFoxInGUI() {
        setBackground(Color.YELLOW);
        setText("Fox");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getText().equals("")) {
            itemType.doAction(x, y, controller);
        }
    }

    @Override
    public void removeActionActionListener() {
        removeActionListener(this);
    }

    @Override
    public void addActionActionListener() {
        addActionListener(this);
    }

    @Override
    public void setXY(int m, int n) {
        this.x = m;
        this.y = n;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void addLifesInGUI(int value) {
        setBackground(Color.RED);
        setText("H" + value);
    }

    @Override
    public void addTrapInGUI(int value) {
        setBackground(Color.BLUE);
        setText("T" + value);

    }

    @Override
    public void addRandomPrizeInGUI(int randomValue) {
        setBackground(Color.GREEN);
        setText("RP" + randomValue);

    }

    @Override
    public void setEnable(boolean b) {
        setEnabled(b);
    }

    @Override
    public void addCarrotInGUI() {
        setBackground(Color.ORANGE);
        setText("C");
    }


}
