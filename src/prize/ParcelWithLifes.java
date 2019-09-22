package prize;

import game.GameFactoryRole;
import player.PlayerRole;
import player.RabbitWithHealth;

import java.io.Serializable;

public class ParcelWithLifes implements PrizeStateRole, Serializable {

    private final GameFactoryRole gameFactory;
    private PrizeStateRole nextPrizeState;
    private int value;
    private int x;
    private int y;
    private PrizeStateRole prizeState;

    public ParcelWithLifes(ParcelWithoutPrize otherNextPrizeState, int otherValue, int otherX, int otherY, GameFactoryRole otherGameFactory) {
        this.nextPrizeState = otherNextPrizeState;
        this.value = otherValue;
        this.x = otherX;
        this.y = otherY;
        this.gameFactory = otherGameFactory;
    }

    @Override
    public void visitedBy(PlayerRole player) {
        prizeState = this;
    }

    @Override
    public PrizeStateRole next() {
        return nextPrizeState;
    }

    @Override
    public void visitedByPlayerWithHealth(RabbitWithHealth rabbitWithHealth) {
        rabbitWithHealth.increaseHealth(value);
        gameFactory.removeParcelWithLifes(this);
        prizeState = next();
        gameFactory.removeParcelWithRandomPrize(this);
    }

    @Override
    public PrizeStateRole getPrizeState() {
        return prizeState;
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
