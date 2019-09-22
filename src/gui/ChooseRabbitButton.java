package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class ChooseRabbitButton extends JButton implements ActionListener, Serializable {

    private int rows;
    private int columns;
    private ParcelFrameRole[][] cell;

    public ChooseRabbitButton(int otherRows, int otherColumns, ParcelFrameRole[][] otherCell) {
        addActionListener(this);
        this.rows = otherRows;
        this.columns = otherColumns;
        this.cell = otherCell;
        setText("R");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ChooseRabbitFrame chooseRabbitFrame = new ChooseRabbitFrame(rows, columns, cell);
    }

}
