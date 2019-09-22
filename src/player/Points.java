package player;

import java.io.Serializable;

public class Points implements PointsRole, Serializable {

    private int score;

    public Points(int otherScore) {
        this.score = otherScore;
    }

    @Override
    public void add(int value) {
        score += value;
    }

    @Override
    public int getScore() {
        return score;
    }
}
