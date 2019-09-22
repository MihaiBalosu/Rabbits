package position;

import java.util.ArrayList;
import java.util.Random;

public class DiagonalPositionStateFactory implements PositionStateFactoryRole {

    private PositionStateRole principalDiagonalUpDown;
    private PositionStateRole principalDiagonalDownUp;
    private PositionStateRole secondaryDiagonalUpDown;
    private PositionStateRole secondaryDiagonalDownUp;
    private DynamicPositionRole rabbitPosition;

    public DiagonalPositionStateFactory(int x, int y, int rows, int columns) {

        rabbitPosition = new DynamicPosition(x, y);
        rabbitPosition.setDimensions(rows, columns);

        this.principalDiagonalUpDown = new MovementPrincipalDiagonalUpDown(rabbitPosition);
        this.principalDiagonalDownUp = new MovementPrincipalDiagonalDownUp(rabbitPosition);
        this.secondaryDiagonalUpDown = new MovementSecondaryDiagonalUpDown(rabbitPosition);
        this.secondaryDiagonalDownUp = new MovementSecondaryDiagonalDownUp(rabbitPosition);

        setNextPositionState();
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
