package parcel;

import player.EnemyRole;
import player.PlayerRole;
import player.RabbitWithHealth;
import prize.PrizeStateRole;

public interface ParcelRole {
    void visitedBy(PlayerRole player);

    PrizeStateRole getPrizeState();

    void visitPlayerWithHealth(RabbitWithHealth rabbitWithHealth);

    void visitedByEnemy(PlayerRole player, EnemyRole fox);
}
