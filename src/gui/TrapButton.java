package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class TrapButton extends JButton implements ActionListener, Serializable {
    private int rows;
    private int columns;
    private ParcelFrameRole[][] cell;

    public TrapButton(String name, ParcelFrameRole[][] otherCell, int otherRows, int otherColumns) {
        addActionListener(this);
        this.rows = otherRows;
        this.columns = otherColumns;
        this.cell = otherCell;
        setText(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ItemTypeRole itemType = new TrapItem();
        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                ((InnerParcelFrame) cell[x][y]).removeActionActionListener();
                cell[x][y].setEnable(false);
            }
        }
        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                ((InnerParcelFrame) cell[x][y]).addActionActionListener();
                cell[x][y].setEnable(true);
                ((InnerParcelFrame) cell[x][y]).setItemType(itemType);
            }
        }
    }
}
