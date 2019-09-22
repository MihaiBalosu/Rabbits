package game;

import player.EnemyRole;
import player.PlayerRole;
import prize.ParcelWithEgg;
import prize.ParcelWithLifes;
import prize.ParcelWithTrap;
import prize.PrizeStateRole;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;

public interface GameFactoryRole {

    GameRole createGame() throws FileNotFoundException;

    void createField(int length, int columns);

    void addLifePoints(int x, int y, int value);

    void addPlayerWithLifes(int x, int y, int value);

    void updateField();

    void addPlayer(int x, int y);

    void addEgg(int x, int y, int value);

    void addTrap(int x, int y, int value);

    void addRandomPrize(int x, int y, int randomValue);

    PlayerRole getPlayer();

    Color getPlayerColor();

    int getPlayerIndex();

    List<ParcelWithEgg> getParcelsWithEgg();

    void removeParcelWithEgg(ParcelWithEgg parcelWithEgg);

    List<ParcelWithLifes> getParcelsWithLifes();

    List<ParcelWithTrap> getParcelsWithTrap();

    void removeParcelWithLifes(ParcelWithLifes parcelWithLifes);

    void addFox(int x, int y);

    List<EnemyRole> getEnemies();

    List<PrizeStateRole> createListOfPrizes(int x, int y, int randomValue);

    PrizeStateRole createRandomPrize(int randomValue, int x, int y);

    List<PrizeStateRole> getParcelsWithRandomPrize();

    void removeParcelWithRandomPrize(PrizeStateRole parcel);
}
