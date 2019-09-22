package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class ChoosePrizeButton extends JButton implements ActionListener, Serializable {

    private ParcelFrameRole[][] cell;
    private int rows;
    private int columns;

    public ChoosePrizeButton(ParcelFrameRole[][] otherCell, int otherRows, int otherColumns) {
        addActionListener(this);
        this.cell = otherCell;
        this.rows = otherRows;
        this.columns = otherColumns;
        setText("E");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ChoosePrizeFrame choosePrizeFrame = new ChoosePrizeFrame(rows, columns, cell);
    }

}
