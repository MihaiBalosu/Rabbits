package controller;

import gui.FieldFrameBuilder;
import gui.StartGameFrame;
import game.Game;
import game.GameFactory;
import game.GameFactoryRole;
import io.Output;
import io.OutputRole;
import player.EnemyRole;
import player.PlayerRole;
import prize.ParcelWithEgg;
import prize.ParcelWithLifes;
import prize.ParcelWithTrap;
import prize.PrizeStateRole;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller implements Serializable {

    private Game game;
    private GameFactoryRole gameFactory;
    private FieldFrameBuilder fieldFrame;

    public Controller(GameFactoryRole otherGameFactory) {
        this.gameFactory = otherGameFactory;
    }

    public void createFieldFrame() throws FileNotFoundException {
        game = (Game) gameFactory.createGame();
        fieldFrame = new FieldFrameBuilder(game);
        fieldFrame.setController(this);
    }

    public void createParcels(int rows, int columns) {
        gameFactory.createField(rows, columns);
        fieldFrame.build(rows, columns);
    }

    public void addPlayerWithLifes(int x, int y, int value) {
        gameFactory.addPlayerWithLifes(x, y, value);
        fieldFrame.addPlayerInGUI(x, y, gameFactory.getPlayerColor(), gameFactory.getPlayerIndex());
        addPlayerInfoInTable(gameFactory.getPlayer());
    }

    public void addLifePoints(int x, int y, int value) {
        gameFactory.addLifePoints(x, y, value);
        fieldFrame.addLifesInGUI(x, y, value);
    }

    public void updateField() {
        gameFactory.updateField();
    }

    public void addPlayer(int x, int y) {
        gameFactory.addPlayer(x, y);
        fieldFrame.addPlayerInGUI(x, y, gameFactory.getPlayerColor(), gameFactory.getPlayerIndex());
        addPlayerInfoInTable(gameFactory.getPlayer());

    }

    public void startGame() {
        StartGameFrame window = new StartGameFrame(this);
        window.setVisible(true);
    }

    public void addEgg(int x, int y, int value) {
        gameFactory.addEgg(x, y, value);
        fieldFrame.addEggInGUI(x, y, value);

    }

    public void addTrap(int x, int y, int value) {
        gameFactory.addTrap(x, y, value);
        fieldFrame.addTrapInGUI(x, y, value);
    }

    public void playTurn() {
        clearAllParcels();
        game.play();
        updateParcelsWithEggsInGUI();
        updateParcelsWithLifesInGUI();
        updateParcelsWithTrapsInGUI();
        updateParcelsWithRandomPrizes();
        updatePlayersInGUI();
        updateEnemiesInGUI();
    }

    private void clearAllParcels() {
        fieldFrame.clearAllParcels();
    }

    private void updatePlayersInGUI() {
        List<PlayerRole> players = game.getPlayersInField();
        for (PlayerRole player : players) {
            fieldFrame.addPlayerInGUI(player.getX(), player.getY(), player.getColor(), player.getIndex());
        }
    }

    private void updateEnemiesInGUI() {
        List<EnemyRole> enemies = gameFactory.getEnemies();
        for (EnemyRole enemy : enemies) {
            fieldFrame.addFoxInGUI(enemy.getX(), enemy.getY());
        }
    }

    private void updateParcelsWithTrapsInGUI() {
        List<ParcelWithTrap> parcelsWithTrap = gameFactory.getParcelsWithTrap();
        for (ParcelWithTrap parcelWithTrap : parcelsWithTrap) {
            fieldFrame.addTrapInGUI(parcelWithTrap.getX(), parcelWithTrap.getY(), parcelWithTrap.getValue());
        }
    }

    private void updateParcelsWithLifesInGUI() {
        List<ParcelWithLifes> parcelsWithLifes = gameFactory.getParcelsWithLifes();
        for (ParcelWithLifes parcelWithLifes : parcelsWithLifes) {
            fieldFrame.addLifesInGUI(parcelWithLifes.getX(), parcelWithLifes.getY(), parcelWithLifes.getValue());
        }
    }

    private void updateParcelsWithEggsInGUI() {
        List<ParcelWithEgg> parcelsWithEgg = gameFactory.getParcelsWithEgg();
        for (ParcelWithEgg parcelWithEgg : parcelsWithEgg) {
            fieldFrame.addEggInGUI(parcelWithEgg.getX(), parcelWithEgg.getY(), parcelWithEgg.getValue());
        }
    }

    private void updateParcelsWithRandomPrizes() {
        List<PrizeStateRole> parcelsWithEgg = gameFactory.getParcelsWithRandomPrize();
        for (PrizeStateRole parcelWithEgg : parcelsWithEgg) {
            fieldFrame.addRandomPrizeInGUI(parcelWithEgg.getX(), parcelWithEgg.getY(), parcelWithEgg.getValue());
        }
    }

    public void updateInfoTable() {
        List<PlayerRole> players = game.getAllPlayers();
        fieldFrame.clearInfoTable();
        for (PlayerRole player : players) {
            addPlayerInfoInTable(player);
        }
    }

    private void addPlayerInfoInTable(PlayerRole player) {
        ArrayList<String> playerInfo = new ArrayList<>();
        playerInfo.add(String.valueOf(player.getIndex()));
        String score = String.valueOf(player.getScore());
        playerInfo.add(score);
        String status = player.getStatus();
        playerInfo.add(status);
        int noOfLifes = player.getNumberOfLifes();
        playerInfo.add(String.valueOf(noOfLifes));
        int healthPoints = player.getHealthPoints();
        playerInfo.add(String.valueOf(healthPoints));
        fieldFrame.updatePlayerInfoTable(playerInfo.toArray());

    }

    public void addRandomPrize(int x, int y) {
        Random random = new Random();
        int randomValue = random.nextInt(10);
        gameFactory.addRandomPrize(x, y, randomValue);
        fieldFrame.addRandomPrizeInGUI(x, y, randomValue);
    }

    public void addFox(int x, int y) {
        gameFactory.addFox(x, y);
        fieldFrame.addFoxInGUI(x, y);
    }

    public void restart() {
        OutputRole output = new Output();
        GameFactoryRole gameFactory = new GameFactory(output);
        Controller controller = new Controller(gameFactory);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                StartGameFrame window = new StartGameFrame(controller);
                window.setVisible(true);
            }
        });
    }
}
