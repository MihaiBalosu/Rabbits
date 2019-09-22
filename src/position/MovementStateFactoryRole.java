package position;

public interface MovementStateFactoryRole {
    PositionStateRole buildMovementNorthToSouth();

    PositionStateRole buildMovementSouthToNorth();

    PositionStateRole buildMovementEastToWest();

    PositionStateRole buildMovementWestToEast();

    PositionStateRole buildMovementToSE();

    PositionStateRole buildMovementToSW();

    PositionStateRole buildMovementToNE();

    PositionStateRole buildMovementToNW();

}
