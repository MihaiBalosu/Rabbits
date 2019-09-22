package position;

import java.io.Serializable;

public class MovementPrincipalDiagonalUpDown implements PositionStateRole, Serializable {

    private DynamicPositionRole position;
    private PositionStateRole nextPositionState;

    public MovementPrincipalDiagonalUpDown(DynamicPositionRole otherRabbitPosition) {
        this.position = otherRabbitPosition;
    }

    @Override
    public int getX() {
        return position.getX();
    }

    @Override
    public int getY() {
        return position.getY();
    }

    @Override
    public void move() {
        position.movePrincipalDiagonalUpDown();
    }

    @Override
    public PositionStateRole next() {
        return nextPositionState;
    }

    @Override
    public void setNextState(PositionStateRole anotherPositionState) {
        nextPositionState = anotherPositionState;
    }

    @Override
    public boolean isInitialState() {
        return position.isOnTheTopLeftCorner();
    }

    @Override
    public PositionStateRole inverse() {
        return nextPositionState.next();
    }

}
