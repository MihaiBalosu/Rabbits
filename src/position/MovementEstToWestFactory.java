package position;

import java.io.Serializable;

public class MovementEstToWestFactory implements MovementStateFactoryRole, Serializable {

    private DynamicPositionRole position;

    public MovementEstToWestFactory(DynamicPositionRole otherRabbitPosition) {
        this.position = otherRabbitPosition;
    }

    @Override
    public PositionStateRole build() {
        return new MovementEstToWest(position);
    }
}
