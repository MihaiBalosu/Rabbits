package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class FoxButton extends JButton implements ActionListener, Serializable {

    private ItemTypeRole itemType;
    private int rows;
    private ParcelFrameRole[][] cell;
    private int columns;

    public FoxButton(int otherRows, int otherColumns, ParcelFrameRole[][] otherCell, String name) {
        setText(name);
        this.rows = otherRows;
        this.columns = otherColumns;
        this.cell = otherCell;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        itemType = new FoxItem();
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
