package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class LifesButton extends JButton implements ActionListener, Serializable {

    private int rows;
    private int columns;
    private ParcelFrameRole[][] cell;

    public LifesButton(String name, ParcelFrameRole[][] otherCell, int otherColumns, int otherRows) {
        addActionListener(this);
        this.rows = otherRows;
        this.columns = otherColumns;
        this.cell = otherCell;
        setText(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ItemTypeRole itemType = new LifePointsItem();
        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                ((InnerParcelFrame) cell[x][y]).removeActionActionListener();
            }
        }
        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                ((InnerParcelFrame) cell[x][y]).addActionActionListener();
                ((InnerParcelFrame) cell[x][y]).setItemType(itemType);
            }
        }
    }
}
