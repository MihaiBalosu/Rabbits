package prize;

import player.PlayerRole;
import player.RabbitWithHealth;

import java.io.Serializable;

public class ParcelWithoutPrize implements PrizeStateRole, Serializable {

    @Override
    public void visitedBy(PlayerRole player) {
        // nothing happens, player movement doesn t change its state
    }

    @Override
    public PrizeStateRole next() {
        return this;
    }

    @Override
    public void visitedByPlayerWithHealth(RabbitWithHealth rabbitWithHealth) {
        visitedBy(rabbitWithHealth);
    }

    @Override
    public PrizeStateRole getPrizeState() {
        return next();
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getValue() {
        return 0;
    }

}
