package gui;

import controller.Controller;

import java.io.Serializable;

public class RabbitItem implements ItemTypeRole, Serializable {

    @Override
    public void doAction(int x, int y, Controller controller) {
        controller.addPlayer(x, y);
    }
}
