package position;

import java.io.Serializable;

public class MovementSouthToNorthFactory implements MovementStateFactoryRole, Serializable {

    private DynamicPositionRole position;

    public MovementSouthToNorthFactory(DynamicPositionRole otherRabbitPosition) {
        this.position = otherRabbitPosition;
    }

    @Override
    public PositionStateRole build() {
        return new MovementSouthToNorth(position);
    }
}
