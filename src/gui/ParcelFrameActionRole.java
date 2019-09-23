package gui;

import controller.Controller;

public interface ParcelFrameActionRole {

    void addEggInGUI(int value);

    void removeActionActionListener();

    void addActionActionListener();

    void setXY(int m, int n);

    void setController(Controller controller);

    void setItemType(ItemTypeRole eggButton);

    void addFoxInGUI();

    void addLifesInGUI(int value);

    void addTrapInGUI(int value);

    void addRandomPrizeInGUI(int randomValue);

    void addCarrotInGUI();
}
