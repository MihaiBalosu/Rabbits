package position;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class PositionStateFactory implements PositionStateFactoryRole, Serializable {

    private MovementStateFactoryRole movementFactory;
    private PositionStateRole northState;
    private PositionStateRole southState;
    private PositionStateRole estState;
    private PositionStateRole westState;
    private DynamicPositionRole rabbitPosition;

    public PositionStateFactory(int x, int y, int rows, int columns) {

        rabbitPosition = new DynamicPosition(x, y);
        rabbitPosition.setDimensions(rows, columns);
        buildMovements();
        setNextPositionState();
    }

    private void buildMovements() {
        movementFactory = new MovementStateFactory(rabbitPosition);
        this.northState = movementFactory.buildMovementNorthToSouth();
        this.southState = movementFactory.buildMovementSouthToNorth();
        this.estState = movementFactory.buildMovementEastToWest();
        this.westState = movementFactory.buildMovementWestToEast();
    }

    private void setNextPositionState() {
        northState.setNextState(estState);
        southState.setNextState(westState);
        estState.setNextState(southState);
        westState.setNextState(northState);
    }

    @Override
    public PositionStateRole buildInitialPositionState() {
        PositionStateRole currentState = southState;

        while (true) {
            if (currentState.isInitialState()) {
                break;
            }
            currentState = currentState.next();
        }

        return currentState;
    }

    @Override
    public PositionStateRole buildRandomPositionState() {
        ArrayList<PositionStateRole> positionStateList = new ArrayList<>();
        positionStateList.add(northState);
        positionStateList.add(southState);
        positionStateList.add(estState);
        positionStateList.add(westState);
        Random randomNumber = new Random();
        PositionStateRole finalPositionState = positionStateList.get(randomNumber.nextInt(positionStateList.size()));
        return finalPositionState;
    }


}
