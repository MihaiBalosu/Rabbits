package prize;

import field.FieldRole;
import game.GameFactory;
import game.GameFactoryRole;
import player.PlayerRole;
import player.RabbitWithHealth;

import java.io.Serializable;

public class ParcelWithTrap implements PrizeStateRole, Serializable {

    private final GameFactoryRole gameFactory;
    private int value;
    private int x;
    private int y;
    private FieldRole field;

    public ParcelWithTrap(int otherValue, int otherX, int otherY, GameFactory otherGameFactory, FieldRole otherField) {
        this.value = otherValue;
        this.x = otherX;
        this.y = otherY;
        this.gameFactory = otherGameFactory;
        this.field = otherField;
    }

    @Override
    public void visitedBy(PlayerRole player) {
        player.changeStatus();
        field.endGameFor(player);
    }

    @Override
    public PrizeStateRole next() {
        return this;
    }

    @Override
    public void visitedByPlayerWithHealth(RabbitWithHealth rabbitWithHealth) {
        rabbitWithHealth.decreaseHealthWithValue(value);
        if (rabbitWithHealth.isDead()) {
            rabbitWithHealth.changeStatus();
            field.endGameFor(rabbitWithHealth);
        }

    }

    @Override
    public PrizeStateRole getPrizeState() {
        return this;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getValue() {
        return value;
    }

}
