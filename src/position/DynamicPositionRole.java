package position;

public interface DynamicPositionRole extends PositionRole {

    void setDimensions(int length, int columns);

    void goToWest();

    void goToEast();

    void goToSouth();

    void goToNorth();

    boolean isOnTheNorthBorder();

    boolean isOnTheSouthBorder();

    boolean isOnTheEstBorder();

    boolean isOnTheWestBorder();

    void movePrincipalDiagonalUpDown();

    boolean isOnTheTopLeftCorner();

    boolean isOnTheTopRighttCorner();

    void moveSecondaryDiagonalUpDown();

    void movePrincipalDiagonalDownUp();

    boolean isOnTheButtomRightCorner();

    void moveSecondaryDiagonalDownUp();

    boolean isOnTheButtomLeftCorner();

    boolean isDiagonal();
}
