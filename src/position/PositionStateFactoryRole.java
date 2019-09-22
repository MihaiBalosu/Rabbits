package position;

public interface PositionStateFactoryRole {

    PositionStateRole buildInitialPositionState();

    PositionStateRole buildRandomPositionState();
}
