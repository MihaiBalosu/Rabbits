package player;

import java.awt.*;

public interface PlayerRole {
    void turn();

    void collectPrize(int value);

    void switchPositionState();

    int getScore();

    boolean isDead();

    int getX();

    int getY();

    void setRandomColor();

    Color getColor();

    String getStatus();

    void changeStatus();

    int getNumberOfLifes();

    int getIndex();

    int getHealthPoints();

    void increaseInvincibility(int value);

    boolean isInvincible();

    void decreaseInvincibility();

}
