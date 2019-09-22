package gui;

import controller.Controller;

import java.io.Serializable;

public class FoxItem implements ItemTypeRole, Serializable {

    @Override
    public void doAction(int x, int y, Controller controller) {
        controller.addFox(x, y);
    }

}
