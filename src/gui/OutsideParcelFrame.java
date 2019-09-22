package gui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class OutsideParcelFrame extends JButton implements ParcelFrameRole, Serializable {

    public OutsideParcelFrame() {
        setEnabled(false);
        setBackground(Color.red);
    }

    @Override
    public void addPlayer(Color color, int index) {
        // nothings happens here because players cannot be placed on a outside parcel

    }

}
