package game;

import field.FieldFactory;
import field.FieldFactoryRole;
import field.FieldRole;
import io.OutputRole;
import parcel.*;
import player.*;
import position.*;
import prize.*;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameFactory implements GameFactoryRole, Serializable {

    private ArrayList<PrizeStateRole> parcelsWithRandomPrize;
    private ParcelRole[][] parcels;
    private FieldRole field;
    private List<PlayerRole> players;
    private OutputRole output;
    private ParcelFactoryRole parcelFactory;
    private PrizeStateFactoryRole prizeStateFactory;
    private int rows;
    private int columns;
    private PositionStateFactoryRole positionStateFactory;
    private PlayerRole rabbit;
    private int playerIndex;
    private List<ParcelWithEgg> parcelsWithEgg;
    private List<ParcelWithLifes> parcelsWithLifes;
    private List<ParcelWithTrap> parcelsWithTrap;
    private List<EnemyRole> enemies;

    public GameFactory(OutputRole otherOutput) {
        this.output = otherOutput;
        playerIndex = 1;
        parcelsWithEgg = new ArrayList<>();
        parcelsWithTrap = new ArrayList<>();
        parcelsWithLifes = new ArrayList<>();
        parcelsWithRandomPrize = new ArrayList<>();
        enemies = new ArrayList<>();
        players = new ArrayList<>();
    }

    @Override
    public void createField(int otherRows, int otherColumns) {
        this.rows = otherRows;
        this.columns = otherColumns;
        parcels = new ParcelRole[rows + 2][columns + 2];
        buildInnerParcels(rows, columns);
        buildOutsideParcels(rows, columns);
    }

    private void buildInnerParcels(int rows, int columns) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                PrizeStateRole prizeState = new ParcelWithoutPrize();
                parcelFactory = new InnerParcelFactory(prizeState);
                ParcelRole parcel = parcelFactory.build();
                parcels[i][j] = parcel;
            }
        }
    }

    private void buildOutsideParcels(int rows, int columns) {
        for (int i = 0; i <= rows + 1; i++) {
            PrizeStateRole prizeState = new ParcelWithoutPrize();
            parcelFactory = new OutsideParcelFactory(field, prizeState);
            parcels[i][0] = parcelFactory.build();
            parcels[i][columns + 1] = parcelFactory.build();
        }

        for (int i = 0; i <= columns + 1; i++) {
            PrizeStateRole prizeState = new ParcelWithoutPrize();
            parcelFactory = new OutsideParcelFactory(field, prizeState);
            parcels[0][i] = parcelFactory.build();
            parcels[rows + 1][i] = parcelFactory.build();
        }
    }

    @Override
    public void addPlayerWithLifes(int x, int y, int value) {
        PositionStateFactoryRole positionStateFactory = new PositionStateFactory(x, y, rows, columns);
        PositionStateRole initialPositionState = positionStateFactory.buildInitialPositionState();
        PlayerFactoryRole playerFactory = new PlayerFactory(field, initialPositionState, playerIndex);
        rabbit = playerFactory.buildPlayerWithLifes(new Life(value));
        players.add(rabbit);
        playerIndex++;
    }

    @Override
    public Game createGame() {

        FieldFactoryRole fieldFactory = new FieldFactory(output);
        field = fieldFactory.build();
        Game game = new Game(field, output);
        return game;

    }

    @Override
    public void updateField() {
        field.setPlayersOnField(players);
        field.seEnemies(enemies);
        field.setParcels(parcels);
    }

    @Override
    public void addPlayer(int x, int y) {

        DynamicPositionRole position = new DynamicPosition(x, y);
        position.setDimensions(rows, columns);
        if (position.isDiagonal()) {
            positionStateFactory = new DiagonalPositionStateFactory(x, y, rows, columns);
        } else {
            positionStateFactory = new PositionStateFactory(x, y, rows, columns);
        }

        PositionStateRole initialPositionState = positionStateFactory.buildInitialPositionState();

        PlayerFactoryRole playerFactory = new PlayerFactory(field, initialPositionState, playerIndex);
        rabbit = playerFactory.buildPlayer();
        players.add(rabbit);
        playerIndex++;

    }

    @Override
    public void addEgg(int x, int y, int value) {
        prizeStateFactory = new ParcelWithPrizeFactory(parcels[x][y].getPrizeState(), value, x, y, this);
        ParcelWithEgg parcelWithPrize = prizeStateFactory.buildParcelWithEgg();
        parcelsWithEgg.add(parcelWithPrize);
        ((InnerParcel) parcels[x][y]).setPrizeState(parcelWithPrize);
    }

    @Override
    public void addLifePoints(int x, int y, int value) {
        prizeStateFactory = new ParcelWithPrizeFactory(parcels[x][y].getPrizeState(), value, x, y, this);
        ParcelWithLifes parcelWithHealthPoints = prizeStateFactory.buildParcelWithLifePoints();
        parcelsWithLifes.add(parcelWithHealthPoints);
        ((InnerParcel) parcels[x][y]).setPrizeState(parcelWithHealthPoints);

    }

    @Override
    public void addTrap(int x, int y, int value) {
        prizeStateFactory = new ParcelWithPrizeFactory(parcels[x][y].getPrizeState(), value, x, y, this);
        ParcelWithTrap trap = prizeStateFactory.buildParcelWithTrap(field);
        parcelsWithTrap.add(trap);
        ((InnerParcel) parcels[x][y]).setPrizeState(trap);
    }

    @Override
    public void addRandomPrize(int x, int y, int randomValue) {
        PrizeStateRole randomPrize = createRandomPrize(randomValue, x, y);
        ((InnerParcel) parcels[x][y]).setPrizeState(randomPrize);
        parcelsWithRandomPrize.add(randomPrize);
    }

    @Override
    public PrizeStateRole createRandomPrize(int randomValue, int x, int y) {
        Random random = new Random();
        List<PrizeStateRole> listOfPrizes = createListOfPrizes(x, y, randomValue);
        PrizeStateRole randomPrize = listOfPrizes.get(random.nextInt(listOfPrizes.size()));
        return randomPrize;
    }

    @Override
    public List<PrizeStateRole> getParcelsWithRandomPrize() {
        return parcelsWithRandomPrize;
    }

    @Override
    public void removeParcelWithRandomPrize(PrizeStateRole parcel) {
        parcelsWithRandomPrize.remove(parcel);
    }

    @Override
    public List<PrizeStateRole> createListOfPrizes(int x, int y, int randomValue) {
        prizeStateFactory = new ParcelWithPrizeFactory(parcels[x][y].getPrizeState(), randomValue, x, y, this);
        PrizeStateRole parcelWithPrize = prizeStateFactory.buildParcelWithEgg();
        PrizeStateRole parcelWithHealthPoints = prizeStateFactory.buildParcelWithLifePoints();
        PrizeStateRole parcelWithTrap = prizeStateFactory.buildParcelWithTrap(field);
        List<PrizeStateRole> listOfPrizes = new ArrayList<>();
        listOfPrizes.add(parcelWithPrize);
        listOfPrizes.add(parcelWithHealthPoints);
        listOfPrizes.add(parcelWithTrap);
        return listOfPrizes;
    }

    @Override
    public PlayerRole getPlayer() {
        return rabbit;
    }

    @Override
    public Color getPlayerColor() {
        return rabbit.getColor();
    }

    @Override
    public int getPlayerIndex() {
        return rabbit.getIndex();
    }

    @Override
    public List<ParcelWithEgg> getParcelsWithEgg() {
        return parcelsWithEgg;
    }

    @Override
    public void removeParcelWithEgg(ParcelWithEgg parcelWithEgg) {
        parcelsWithEgg.remove(parcelWithEgg);
    }

    @Override
    public List<ParcelWithLifes> getParcelsWithLifes() {
        return parcelsWithLifes;
    }

    @Override
    public List<ParcelWithTrap> getParcelsWithTrap() {
        return parcelsWithTrap;
    }

    @Override
    public void removeParcelWithLifes(ParcelWithLifes parcelWithLifes) {
        parcelsWithLifes.remove(parcelWithLifes);
    }

    @Override
    public void addFox(int x, int y) {
        DynamicPositionRole position = new DynamicPosition(x, y);
        position.setDimensions(rows, columns);
        positionStateFactory = new PositionStateFactory(x, y, rows, columns);
        PositionStateRole initialPositionState = positionStateFactory.buildRandomPositionState();
        Fox fox = new Fox(field, initialPositionState);
        enemies.add(fox);
    }

    @Override
    public List<EnemyRole> getEnemies() {
        return field.getEnemies();
    }

}
