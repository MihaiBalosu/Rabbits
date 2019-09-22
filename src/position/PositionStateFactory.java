package position;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class PositionStateFactory implements PositionStateFactoryRole, Serializable {

    private PositionStateRole northState;
    private PositionStateRole southState;
    private PositionStateRole estState;
    private PositionStateRole westState;
    private DynamicPositionRole rabbitPosition;

    public PositionStateFactory(int x, int y, int rows, int columns) {

        rabbitPosition = new DynamicPosition(x, y);
        rabbitPosition.setDimensions(rows, columns);


        MovementStateFactoryRole northStateFactory = new MovementNorthToSouthFactory(rabbitPosition);
        MovementStateFactoryRole southStateFactory = new MovementSouthToNorthFactory(rabbitPosition);
        MovementStateFactoryRole estStateFactory = new MovementEstToWestFactory(rabbitPosition);
        MovementStateFactoryRole westStateFactory = new MovementWestToEstFactory(rabbitPosition);

        this.northState = northStateFactory.build();
        this.southState = southStateFactory.build();
        this.estState = estStateFactory.build();
        this.westState = westStateFactory.build();

        setNextPositionState();
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
