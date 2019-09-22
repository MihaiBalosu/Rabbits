package prize;

import field.FieldRole;
import game.GameFactory;

import java.io.Serializable;

public class ParcelWithPrizeFactory implements PrizeStateFactoryRole, Serializable {


    private GameFactory gameFactory;
    private PrizeStateRole prizeState;
    private int x;
    private int y;
    private int value;

    public ParcelWithPrizeFactory(PrizeStateRole otherNextPrizeState, int otherValue, int otherX, int otherY, GameFactory otherGameFactory) {
        this.prizeState = otherNextPrizeState;
        this.x = otherX;
        this.y = otherY;
        this.gameFactory = otherGameFactory;
        this.value = otherValue;

    }

    @Override
    public ParcelWithEgg buildParcelWithEgg() {
        return new ParcelWithEgg(prizeState, value, x, y, gameFactory);
    }

    @Override
    public ParcelWithLifes buildParcelWithLifePoints() {
        return new ParcelWithLifes((ParcelWithoutPrize) prizeState, value, x, y, gameFactory);
    }

    @Override
    public ParcelWithTrap buildParcelWithTrap(FieldRole field) {
        return new ParcelWithTrap(value, x, y, gameFactory, field);
    }


}
