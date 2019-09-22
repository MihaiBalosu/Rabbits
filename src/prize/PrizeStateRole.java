package prize;

import player.PlayerRole;
import player.RabbitWithHealth;


public interface PrizeStateRole {

    void visitedBy(PlayerRole player);

    PrizeStateRole next();

    void visitedByPlayerWithHealth(RabbitWithHealth rabbitWithHealth);

    PrizeStateRole getPrizeState();

    int getX();

    int getY();

    int getValue();
}
