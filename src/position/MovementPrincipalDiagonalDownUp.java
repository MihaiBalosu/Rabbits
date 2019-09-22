package position;

public class MovementPrincipalDiagonalDownUp implements PositionStateRole {

    private DynamicPositionRole position;
    private PositionStateRole nextPositionState;

    public MovementPrincipalDiagonalDownUp(DynamicPositionRole otherRabbitPosition) {
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
        position.movePrincipalDiagonalDownUp();
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
        return position.isOnTheButtomRightCorner();
    }

    @Override
    public PositionStateRole inverse() {
        return nextPositionState.next();
    }


}
