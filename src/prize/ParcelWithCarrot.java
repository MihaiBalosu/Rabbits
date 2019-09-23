package prize;

import game.GameFactoryRole;
import player.PlayerRole;
import player.RabbitWithHealth;

import java.io.Serializable;

public class ParcelWithCarrot implements PrizeStateRole, Serializable {

    private int value;
    private PrizeStateRole nextPrizeState;
    private PrizeStateRole prizeState;
    private int x;
    private int y;
    private GameFactoryRole gameFactory;

    public ParcelWithCarrot(PrizeStateRole otherNextPrizeState, int otherX, int otherY, GameFactoryRole otherGameFactory) {
        this.nextPrizeState = otherNextPrizeState;
        this.x = otherX;
        this.y = otherY;
        this.gameFactory = otherGameFactory;
    }

    @Override
    public void visitedBy(PlayerRole player) {
        player.increaseInvincibility(value);
        gameFactory.removeParcelWithCarrot(this);
        gameFactory.removeParcelWithRandomPrize(this);
    }

    @Override
    public PrizeStateRole next() {
        return nextPrizeState;
    }

    @Override
    public void visitedByPlayerWithHealth(RabbitWithHealth rabbitWithHealth) {
        visitedBy(rabbitWithHealth);
    }

    @Override
    public PrizeStateRole getPrizeState() {
        return prizeState;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getValue() {
        return 1;
    }

}
