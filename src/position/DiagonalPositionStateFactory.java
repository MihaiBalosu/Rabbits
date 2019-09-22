package position;

import java.util.ArrayList;
import java.util.Random;

public class DiagonalPositionStateFactory implements PositionStateFactoryRole {

    private MovementStateFactoryRole movementFactory;
    private PositionStateRole principalDiagonalUpDown;
    private PositionStateRole principalDiagonalDownUp;
    private PositionStateRole secondaryDiagonalUpDown;
    private PositionStateRole secondaryDiagonalDownUp;
    private DynamicPositionRole rabbitPosition;

    public DiagonalPositionStateFactory(int x, int y, int rows, int columns) {

        rabbitPosition = new DynamicPosition(x, y);
        rabbitPosition.setDimensions(rows, columns);
        buildMovements();
        setNextPositionState();
    }

    private void buildMovements() {
        movementFactory = new MovementStateFactory(rabbitPosition);
        this.principalDiagonalUpDown = movementFactory.buildMovementToSW();
        this.principalDiagonalDownUp = movementFactory.buildMovementToNE();
        this.secondaryDiagonalUpDown = movementFactory.buildMovementToSE();
        this.secondaryDiagonalDownUp = movementFactory.buildMovementToNW();
    }

    private void setNextPositionState() {
        principalDiagonalUpDown.setNextState(secondaryDiagonalUpDown);
        principalDiagonalDownUp.setNextState(secondaryDiagonalDownUp);
        secondaryDiagonalUpDown.setNextState(principalDiagonalDownUp);
        secondaryDiagonalDownUp.setNextState(principalDiagonalUpDown);
    }

    @Override
    public PositionStateRole buildInitialPositionState() {
        PositionStateRole currentState = principalDiagonalDownUp;

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
        positionStateList.add(principalDiagonalDownUp);
        positionStateList.add(principalDiagonalUpDown);
        positionStateList.add(secondaryDiagonalDownUp);
        positionStateList.add(secondaryDiagonalUpDown);
        Random randomNumber = new Random();
        PositionStateRole finalPositionState = positionStateList.get(randomNumber.nextInt(positionStateList.size()));
        return finalPositionState;
    }

}
