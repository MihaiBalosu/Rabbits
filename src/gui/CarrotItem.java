package gui;

import controller.Controller;

import java.io.Serializable;

public class CarrotItem implements ItemTypeRole, Serializable {

    @Override
    public void doAction(int x, int y, Controller controller) {
        controller.addCarrot(x, y);
    }

}
