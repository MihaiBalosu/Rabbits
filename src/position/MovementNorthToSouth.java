package position;

import java.io.Serializable;

public class MovementNorthToSouth implements position.PositionStateRole, Serializable {

    private position.DynamicPositionRole position;
    private position.PositionStateRole nextPositionState;

    public MovementNorthToSouth(position.DynamicPositionRole otherRabbitPosition) {
        this.position = otherRabbitPosition;
    }

    @Override
    public void move() {
        position.goToSouth();
    }

    @Override
    public position.PositionStateRole next() {
        return nextPositionState;
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
    public void setNextState(position.PositionStateRole anotherPositionState) {
        nextPositionState = anotherPositionState;
    }

    @Override
    public boolean isInitialState() {
        return position.isOnTheNorthBorder();
    }

    @Override
    public PositionStateRole inverse() {
        return nextPositionState.next();
    }
}
