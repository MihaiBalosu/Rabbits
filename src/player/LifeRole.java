package player;

public interface LifeRole {

    void increaseWith(int value);

    void decrease();

    boolean isEmpty();

    void decreaseHealthWithValue(int value);

    int getHealth();

    int getNumberOfLifes();

    void setHealthPoints(int i);

    void setLife(int i);

    int getTotalHealthPoints();


}
