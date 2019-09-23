package parcel;

import player.EnemyRole;
import player.PlayerRole;
import player.RabbitWithHealth;
import prize.PrizeStateRole;

import java.io.Serializable;

public class InnerParcel implements ParcelRole, Serializable {

    private PrizeStateRole prizeState;

    public InnerParcel(PrizeStateRole otherPrizeState) {

        this.prizeState = otherPrizeState;
    }

    @Override
    public void visitedBy(PlayerRole player) {
        prizeState.visitedBy(player);
        prizeState = prizeState.getPrizeState();
    }

    @Override
    public PrizeStateRole getPrizeState() {
        return prizeState;
    }

    public void setPrizeState(PrizeStateRole anotherPrizeState) {
        prizeState = anotherPrizeState;
    }

    @Override
    public void visitPlayerWithLifes(RabbitWithHealth rabbitWithHealth) {
        prizeState.visitedByPlayerWithHealth(rabbitWithHealth);
        prizeState = prizeState.getPrizeState();
    }

    @Override
    public void visitedByEnemy(PlayerRole player, EnemyRole fox) {
        if (fox.hasSamePositionAs(player)) {
            fox.attack(player);
        }
    }

}
