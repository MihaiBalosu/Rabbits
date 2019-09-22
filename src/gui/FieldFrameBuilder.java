package gui;

import controller.Controller;
import game.Game;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.Serializable;

public class FieldFrameBuilder extends JFrame implements FieldFrameBuilderRole, Serializable {

    private ParcelFrameRole[][] cell;
    private JSplitPane split;
    private int rows;
    private int columns;
    private Game game;
    private Controller controller;
    private StartTurnButton startTurn;
    private DefaultTableModel playersInfoTable;
    private JTable playersStatsTable;

    public FieldFrameBuilder(Game otherGame) {
        this.game = otherGame;
    }

    @Override
    public void build(int rows, int columns) {

        this.rows = rows;
        this.columns = columns;
        setTitle("RabbitsGame");
        setBounds(650, 200, 1000, 400);
        cell = new ParcelFrameRole[rows + 2][columns + 2];
        JPanel panel = new JPanel(new GridLayout(rows + 2, columns + 2));
        panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

        for (int m = 0; m < rows + 2; m++) {
            for (int n = 0; n < columns + 2; n++) {
                if (m == 0 || n == 0 || m == rows + 1 || n == columns + 1) {
                    cell[m][n] = new OutsideParcelFrame();
                } else {
                    cell[m][n] = new InnerParcelFrame();
                    ((InnerParcelFrame) cell[m][n]).setXY(m, n);
                    ((InnerParcelFrame) cell[m][n]).setController(controller);
                }
                cell[m][n].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add((Component) cell[m][n]);
                add(panel);
            }
        }
        JPanel controlPanel = new JPanel();

        GetOutputButton getOutputButton = new GetOutputButton("Get Output", game);
        controlPanel.add(getOutputButton);

        startTurn = new StartTurnButton("Start Turn", game, controller, getOutputButton);
        controlPanel.add(startTurn);

        RestartButton restartButton = new RestartButton("Restart", controller, this);
        controlPanel.add(restartButton);

        ChoosePrizeButton choosePrizeButton = new ChoosePrizeButton(cell, rows, columns);
        controlPanel.add(choosePrizeButton);

        ChooseRabbitButton chooseRabbitButton = new ChooseRabbitButton(rows, columns, cell);
        controlPanel.add(chooseRabbitButton);

        FoxButton foxButton = new FoxButton(rows, columns, cell, "Fox");
        controlPanel.add(foxButton);

        FieldFrameBuilder gameView = this;
        SaveButton saveButton = new SaveButton("Save", gameView);

        controlPanel.add(saveButton);

        String[] columnNames = {"Player Nr", "Points", "Status", "Lifes", "Health Points"};

        playersInfoTable = new DefaultTableModel(columnNames, 0);
        playersStatsTable = new JTable(playersInfoTable);

        JScrollPane sp = new JScrollPane(playersStatsTable);
        controlPanel.add(sp);

        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, controlPanel, panel);
        split.setDividerLocation(500);
        add(split);

        setVisible(true);
    }

    @Override
    public void addPlayerInGUI(int x, int y, Color color, int index) {
        cell[x][y].addPlayer(color, index);
        setVisible(true);
    }

    @Override
    public void addEggInGUI(int x, int y, int value) {
        ((InnerParcelFrame) cell[x][y]).addEggInGUI(value);
        setVisible(true);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void addLifesInGUI(int x, int y, int value) {
        ((InnerParcelFrame) cell[x][y]).addLifesInGUI(value);
        setVisible(true);
    }

    @Override
    public void addTrapInGUI(int x, int y, int value) {
        ((InnerParcelFrame) cell[x][y]).addTrapInGUI(value);
        setVisible(true);
    }

    @Override
    public void updatePlayerInfoTable(Object[] playerInfo) {

        playersInfoTable.addRow(playerInfo);
        playersInfoTable.fireTableDataChanged();

    }

    @Override
    public void addRandomPrizeInGUI(int x, int y, int randomValue) {
        ((InnerParcelFrame) cell[x][y]).addRandomPrizeInGUI(randomValue);
        setVisible(true);
    }

    @Override
    public void addFoxInGUI(int x, int y) {
        ((InnerParcelFrame) cell[x][y]).addFoxInGUI();
        setVisible(true);
    }

    @Override
    public void clearAllParcels() {
        for (int m = 0; m < rows + 2; m++) {
            for (int n = 0; n < columns + 2; n++) {
                if (m != 0 && n != 0 && n != columns + 1 && m != rows + 1) {
                    ((InnerParcelFrame) cell[m][n]).setText("");
                    ((InnerParcelFrame) cell[m][n]).setBackground(Color.WHITE);
                }
            }
        }
    }

    @Override
    public void clearInfoTable() {
        if (playersInfoTable.getRowCount() > 0) {
            for (int i = playersInfoTable.getRowCount() - 1; i > -1; i--) {
                playersInfoTable.removeRow(i);
            }
            playersInfoTable.fireTableDataChanged();
        }
    }
}
