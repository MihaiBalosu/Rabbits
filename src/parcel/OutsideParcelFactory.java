package parcel;

import field.FieldRole;
import prize.PrizeStateRole;

import java.io.Serializable;

public class OutsideParcelFactory implements ParcelFactoryRole, Serializable {


    private PrizeStateRole prizeState;
    private FieldRole field;

    public OutsideParcelFactory(FieldRole otherField, PrizeStateRole otherPrizeState) {
        this.field = otherField;
        this.prizeState = otherPrizeState;
    }

    @Override
    public ParcelRole build() {
        return new OutsideParcel(field, prizeState);
    }
}
