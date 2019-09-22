package parcel;

import prize.PrizeStateRole;

import java.io.Serializable;

public class InnerParcelFactory implements ParcelFactoryRole, Serializable {
    private PrizeStateRole prizeState;

    public InnerParcelFactory(PrizeStateRole otherPrizeState) {
        this.prizeState = otherPrizeState;
    }

    @Override
    public ParcelRole build() {
        return new InnerParcel(prizeState);
    }
}
