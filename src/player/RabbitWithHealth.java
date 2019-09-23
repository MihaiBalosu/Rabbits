package player;

import field.FieldRole;
import position.PositionStateRole;

import java.awt.*;
import java.io.Serializable;
import java.util.Random;

public class RabbitWithHealth implements PlayerRole, Serializable {

    private LifeRole life;
    private FieldRole field;
    private PositionStateRole positionState;
    private Points score;
    private Color randomColor;
    private String status;
    private int playerIndex;
    private InvincibilityRole invincibility;

    public RabbitWithHealth(FieldRole otherField, PositionStateRole otherPositionState, LifeRole otherLife, int otherPlayerIndex) {
        this.field = otherField;
        this.positionState = otherPositionState;
        this.playerIndex = otherPlayerIndex;
        this.life = otherLife;
        this.invincibility = new Invincibility(0);
        score = new Points(0);
        status = "Alive";

        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        randomColor = new Color(r, g, b);
    }

    @Override
    public void turn() {
        positionState.move();
        field.visitByPlayerWithLifes(positionState, this);

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
        return life.isEmpty();
    }

    public void increaseHealth(int value) {
        life.increaseWith(value);

    }

    public void inverseMovementState() {
        positionState = positionState.inverse();

    }

    public void decreaseLife() {
        life.decrease();

    }

    @Override
    public int getX() {
        return positionState.getX();
    }

    @Override
    public int getY() {
        return positionState.getY();
    }

    public void decreaseHealthWithValue(int value) {
        life.decreaseHealthWithValue(value);

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
        setLifes(0);
        setHealthPoints(0);
    }

    @Override
    public int getNumberOfLifes() {
        return life.getNumberOfLifes();
    }

    @Override
    public int getIndex() {
        return playerIndex;
    }

    @Override
    public int getHealthPoints() {
        return life.getHealth();
    }

    public void setHealthPoints(int i) {
        life.setHealthPoints(i);
    }

    public void setLifes(int i) {
        life.setLife(i);
    }

    @Override
    public void increaseInvincibility(int value) {
        invincibility.increase(value);
    }

    @Override
    public boolean isInvincible() {
        return invincibility.isPositive();
    }

    @Override
    public void decreaseInvincibility() {
        invincibility.decrease();
    }

}
