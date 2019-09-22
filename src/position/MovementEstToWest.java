package position;

import java.io.Serializable;

public class MovementEstToWest implements PositionStateRole, Serializable {

    private DynamicPositionRole position;
    private PositionStateRole nextPositionState;

    public MovementEstToWest(DynamicPositionRole otherRabbitPosition) {
        this.position = otherRabbitPosition;
    }

    @Override
    public void move() {
        position.goToWest();
    }

    @Override
    public PositionStateRole next() {
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
    public void setNextState(PositionStateRole anotherPositionState) {
        nextPositionState = anotherPositionState;

    }

    @Override
    public boolean isInitialState() {
        return position.isOnTheEstBorder();
    }

    @Override
    public PositionStateRole inverse() {
        return nextPositionState.next();
    }
}
