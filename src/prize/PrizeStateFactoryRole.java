package prize;

import field.FieldRole;

public interface PrizeStateFactoryRole {
    ParcelWithEgg buildParcelWithEgg();

    ParcelWithLifes buildParcelWithLifePoints();

    ParcelWithTrap buildParcelWithTrap(FieldRole field);
}
