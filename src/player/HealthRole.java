package player;

public interface HealthRole {

    void increaseWith(int value);

    boolean isEmpty();

    void decreaseWith(int value);

    int getHealthValue();

    int getRemainNumberOfLifes();

    void setHealthPoints(int healthPoints);

    void decreaseTotalHealthPointsWith();

    int getTotalHealthPoints();


}
