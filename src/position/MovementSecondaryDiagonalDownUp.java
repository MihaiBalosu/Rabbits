package position;

public class MovementSecondaryDiagonalDownUp implements PositionStateRole {

    private DynamicPositionRole position;
    private PositionStateRole nextPositionState;

    public MovementSecondaryDiagonalDownUp(DynamicPositionRole otherRabbitPosition) {
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
        position.moveSecondaryDiagonalDownUp();
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
        return position.isOnTheButtomLeftCorner();
    }

    @Override
    public PositionStateRole inverse() {
        return nextPositionState.next();
    }

}
