package position;

public class MovementSecondaryDiagonalUpDown implements PositionStateRole {

    private DynamicPositionRole position;
    private PositionStateRole nextPositionState;

    public MovementSecondaryDiagonalUpDown(DynamicPositionRole otherRabbitPosition) {
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
        position.moveSecondaryDiagonalUpDown();
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
        return position.isOnTheTopRighttCorner();
    }

    @Override
    public PositionStateRole inverse() {
        return nextPositionState.next();
    }
}
