package position;

import java.io.Serializable;

public class MovementNorthToSouthFactory implements MovementStateFactoryRole, Serializable {


    private DynamicPositionRole position;

    public MovementNorthToSouthFactory(DynamicPositionRole otherRabbitPosition) {
        this.position = otherRabbitPosition;
    }

    @Override
    public PositionStateRole build() {
        return new MovementNorthToSouth(position);
    }
}
