package player;

import field.FieldRole;
import position.PositionStateRole;

import java.io.Serializable;
import java.util.List;

public class Fox implements EnemyRole, Serializable {

    private FieldRole field;
    private PositionStateRole positionState;

    public Fox(FieldRole otherField, PositionStateRole otherPositionState) {

        this.field = otherField;
        this.positionState = otherPositionState;
    }

    @Override
    public boolean hasSamePositionAs(PlayerRole player) {
        return positionState.getX() == player.getX() && positionState.getY() == player.getY();
    }

    @Override
    public void kill(PlayerRole player) {
        field.endGameFor(player);
        switchPositionState();
    }

    @Override
    public int getX() {
        return positionState.getX();
    }

    @Override
    public int getY() {
        return positionState.getY();
    }

    @Override
    public void searchFor(PlayerRole player) {
        field.visitByEnemy(player, this);
    }

    private void switchPositionState() {
        positionState = positionState.next();
    }

    @Override
    public void turn(List<PlayerRole> copyList) {
        positionState.move();
        for(PlayerRole player : copyList){
            searchFor(player);
        }

    }
}
