package position;

public interface PositionStateRole extends PositionRole {
    void move();

    PositionStateRole next();

    void setNextState(PositionStateRole anotherPositionState);

    boolean isInitialState();

    PositionStateRole inverse();
}
