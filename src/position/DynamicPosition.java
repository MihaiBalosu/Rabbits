package position;

import java.io.Serializable;

public class DynamicPosition implements DynamicPositionRole, Serializable {

    private int x;
    private int y;
    private int rows;
    private int columns;

    public DynamicPosition(int otherX, int otherY) {
        this.x = otherX;
        this.y = otherY;
    }

    @Override
    public void setDimensions(int otherRows, int otherColumns) {
        this.rows = otherRows;
        this.columns = otherColumns;
    }


    @Override
    public void goToWest() {
        y--;
    }

    @Override
    public void goToEast() {
        y++;
    }

    @Override
    public void goToSouth() {
        x++;
    }

    @Override
    public void goToNorth() {
        x--;
    }

    @Override
    public boolean isOnTheWestBorder() {
        return y == 1;
    }

    @Override
    public boolean isOnTheNorthBorder() {

        return x == 1;
    }

    @Override
    public boolean isOnTheSouthBorder() {
        return x == rows;
    }

    @Override
    public boolean isOnTheEstBorder() {
        return y == columns;
    }


    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void movePrincipalDiagonalUpDown() {
        x++;
        y++;
    }

    @Override
    public boolean isOnTheTopLeftCorner() {
        return y == 1 && x == 1;
    }

    @Override
    public boolean isOnTheTopRighttCorner() {
        return y == columns && x == 1;
    }

    @Override
    public void moveSecondaryDiagonalUpDown() {
        x++;
        y--;
    }

    @Override
    public void movePrincipalDiagonalDownUp() {
        x--;
        y--;
    }

    @Override
    public boolean isOnTheButtomRightCorner() {
        return x == rows && y == columns;
    }

    @Override
    public void moveSecondaryDiagonalDownUp() {
        x--;
        y++;
    }

    @Override
    public boolean isOnTheButtomLeftCorner() {
        return x == rows && y == 1;
    }

    @Override
    public boolean isDiagonal() {
        return isOnTheButtomLeftCorner() || isOnTheButtomRightCorner() || isOnTheTopLeftCorner() || isOnTheTopRighttCorner();
    }
}
