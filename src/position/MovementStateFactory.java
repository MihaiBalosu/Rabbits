package position;

import java.io.Serializable;

public class MovementStateFactory implements MovementStateFactoryRole, Serializable {
    private DynamicPositionRole position;

    public MovementStateFactory(DynamicPositionRole otherPosition) {
        position = otherPosition;
    }

    @Override
    public PositionStateRole buildMovementNorthToSouth() {
        return new MovementNorthToSouth(position);
    }

    @Override
    public PositionStateRole buildMovementSouthToNorth() {
        return new MovementSouthToNorth(position);
    }

    @Override
    public PositionStateRole buildMovementEastToWest() {
        return new MovementEstToWest(position);
    }

    @Override
    public PositionStateRole buildMovementWestToEast() {
        return new MovementWestToEst(position);
    }

    @Override
    public PositionStateRole buildMovementToSE() {
        return new MovementSecondaryDiagonalUpDown(position);
    }

    @Override
    public PositionStateRole buildMovementToSW() {
        return new MovementPrincipalDiagonalUpDown(position);
    }

    @Override
    public PositionStateRole buildMovementToNE() {
        return new MovementPrincipalDiagonalDownUp(position);
    }

    @Override
    public PositionStateRole buildMovementToNW() {
        return new MovementSecondaryDiagonalDownUp(position);
    }
}
