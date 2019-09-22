package gui;

import controller.Controller;

import java.awt.*;

public interface FieldFrameBuilderRole {

    void build(int length, int columns);

    void addEggInGUI(int x, int y, int value);

    void setController(Controller controller);

    void addLifesInGUI(int x, int y, int value);

    void addPlayerInGUI(int x, int y, Color color, int object);

    void addRandomPrizeInGUI(int x, int y, int randomValue);

    void addFoxInGUI(int x, int y);

    void clearInfoTable();

    void clearAllParcels();

    void addTrapInGUI(int x, int y, int value);

    void updatePlayerInfoTable(Object[] playerInfo);
}
