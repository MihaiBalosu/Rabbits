package player;

import java.io.Serializable;

public class Life implements LifeRole, Serializable {

    private HealthRole health;
    private int noOfLifes;

    public Life(int otherNumberOfLifes) {
        this.noOfLifes = otherNumberOfLifes;
        this.health = new Health(noOfLifes);
    }

    @Override
    public void increaseWith(int value) {
        health.increaseWith(value);
        noOfLifes += value;

    }

    @Override
    public void decrease() {
        noOfLifes--;
        health.decreaseTotalHealthPointsWith();
    }

    @Override
    public boolean isEmpty() {
        return health.isEmpty();
    }

    @Override
    public void decreaseHealthWithValue(int value) {
        health.decreaseWith(value);
        noOfLifes = health.getRemainNumberOfLifes();
    }

    @Override
    public int getHealth() {
        return health.getHealthValue();
    }

    @Override
    public int getNumberOfLifes() {
        return noOfLifes;
    }

    @Override
    public void setHealthPoints(int healthPoints) {
        health.setHealthPoints(healthPoints);
    }

    @Override
    public void setLife(int i) {
        noOfLifes = 0;
    }

    @Override
    public int getTotalHealthPoints() {
        return health.getTotalHealthPoints();
    }

}
