package parcel;

import field.FieldRole;
import player.EnemyRole;
import player.PlayerRole;
import player.RabbitWithHealth;
import prize.PrizeStateRole;

import java.io.Serializable;

public class OutsideParcel implements ParcelRole, Serializable {

    private final PrizeStateRole przeState;
    private FieldRole field;

    public OutsideParcel(FieldRole otherField, PrizeStateRole otherPrizeState) {
        this.field = otherField;
        this.przeState = otherPrizeState;
    }

    @Override
    public void visitedBy(PlayerRole player) {
        if (player.isDead()) {
            field.endGameFor(player);
            player.changeStatus();
        }
    }

    @Override
    public PrizeStateRole getPrizeState() {
        return getPrizeState();
    }

    @Override
    public void visitPlayerWithLifes(RabbitWithHealth rabbitWithHealth) {
        rabbitWithHealth.decreaseLife();
        if (rabbitWithHealth.isDead()) {
            field.endGameFor(rabbitWithHealth);
            rabbitWithHealth.changeStatus();
        } else {
            rabbitWithHealth.inverseMovementState();
        }
    }

    @Override
    public void visitedByEnemy(PlayerRole player, EnemyRole fox) {
        field.endGameFor(fox);
    }

}
