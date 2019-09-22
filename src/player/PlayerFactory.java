package player;

import field.FieldRole;
import position.PositionStateRole;

import java.io.Serializable;

public class PlayerFactory implements PlayerFactoryRole, Serializable {


    private FieldRole field;
    private PositionStateRole initialPositionState;
    private int playerIndex;

    public PlayerFactory(FieldRole otherField, PositionStateRole otherPositionState, int otherPlayerIndex) {
        this.field = otherField;
        this.initialPositionState = otherPositionState;
        this.playerIndex = otherPlayerIndex;
    }

    @Override
    public Rabbit buildPlayer() {
        return new Rabbit(field, initialPositionState, playerIndex);
    }

    @Override
    public RabbitWithHealth buildPlayerWithLifes(Life health) {
        return new RabbitWithHealth(field, initialPositionState, health, playerIndex);
    }


}
