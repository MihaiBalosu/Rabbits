package player;

import java.io.Serializable;

public class Health implements HealthRole, Serializable {

    private int totalHealthValue;
    private int healthValue;
    private int healthPointsPerLife = 10;

    public Health(int noOfLives) {
        this.healthValue = healthPointsPerLife;
        this.totalHealthValue = healthPointsPerLife * noOfLives;
    }

    @Override
    public void increaseWith(int value) {
        totalHealthValue += (value * healthPointsPerLife);
    }

    @Override
    public boolean isEmpty() {
        return totalHealthValue <= 0;
    }

    @Override
    public void decreaseWith(int value) {
        totalHealthValue -= value;
        calculateHealthValue(value);
    }

    private void calculateHealthValue(int value) {
        healthValue -= value;
        if (healthValue == 0) {
            healthValue = 10;
        } else if (healthValue < 0) {
            healthValue = 10 - (value % 10);
        }
    }

    @Override
    public int getHealthValue() {
        return healthValue;
    }

    @Override
    public int getRemainNumberOfLifes() {
        int numberOfLifes = totalHealthValue / healthPointsPerLife;
        return numberOfLifes;
    }

    @Override
    public void setHealthPoints(int healthPoints) {
        healthValue = 0;
    }

    @Override
    public void decreaseTotalHealthPointsWith() {
        totalHealthValue -= 10;
    }

    @Override
    public int getTotalHealthPoints() {
        return totalHealthValue;
    }

}
