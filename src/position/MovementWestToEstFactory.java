package position;

import java.io.Serializable;

public class MovementWestToEstFactory implements MovementStateFactoryRole, Serializable {

    private DynamicPositionRole position;

    public MovementWestToEstFactory(DynamicPositionRole otherRabbitPosition) {
        this.position = otherRabbitPosition;
    }

    @Override
    public PositionStateRole build() {
        return new MovementWestToEst(position);
    }
}
