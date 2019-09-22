package player;

import field.FieldRole;
import position.PositionStateRole;

import java.awt.*;
import java.io.Serializable;
import java.util.Random;

public class Rabbit implements PlayerRole, Serializable {

    private FieldRole field;
    private PositionStateRole positionState;
    private PointsRole score;
    private Color randomColor;
    private String status;
    private int numberOfLifes;
    private int playerIndex;

    public Rabbit(FieldRole otherField, PositionStateRole otherPositionState, int otherPlayerIndex) {
        this.field = otherField;
        this.positionState = otherPositionState;
        this.playerIndex = otherPlayerIndex;
        score = new Points(0);
        status = "Alive";
        numberOfLifes = 1;

        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        randomColor = new Color(r, g, b);
    }

    @Override
    public void turn() {
        positionState.move();
        field.visitByPlayerWithHealth(positionState, this);

    }

    @Override
    public void collectPrize(int value) {
        switchPositionState();
        score.add(value);
    }

    @Override
    public void switchPositionState() {
        positionState = positionState.next();
    }

    @Override
    public int getScore() {
        return score.getScore();
    }

    @Override
    public boolean isDead() {
        return true;
    }

    @Override
    public int getX() {
        return positionState.getX();
    }

    @Override
    public int getY() {
        return positionState.getY();
    }

    @Override
    public void setRandomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        randomColor = new Color(r, g, b);
    }

    @Override
    public Color getColor() {
        return randomColor;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void changeStatus() {
        status = "Dead";
        numberOfLifes = 0;
    }

    @Override
    public int getNumberOfLifes() {
        return numberOfLifes;
    }

    @Override
    public int getIndex() {
        return playerIndex;
    }

    @Override
    public int getHealthPoints() {
        return 0;
    }


}
