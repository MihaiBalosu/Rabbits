package field;

import parcel.ParcelRole;
import player.EnemyRole;
import player.PlayerRole;
import player.RabbitWithHealth;
import position.PositionRole;
import position.PositionStateRole;

import java.util.List;

public interface FieldRole {

    boolean hasPlayers();

    void movePlayers();

    void visitByPlayerWithHealth(PositionRole positionState, PlayerRole player);

    void endGameFor(PlayerRole player);

    PlayerRole getWinner();

    void setParcels(ParcelRole[][] parcels);

    void visitByPlayerWithHealth(PositionStateRole positionState, RabbitWithHealth rabbitWithHealth);

    List<PlayerRole> getPlayersOnField();

    void setPlayersOnField(List<PlayerRole> players);

    List<PlayerRole> getAllPlayer();

    void seEnemies(List<EnemyRole> enemies);

    void visitByEnemy(PlayerRole player, EnemyRole fox);

    void endGameFor(EnemyRole fox);

    List<EnemyRole> getEnemies();

    void moveEnemies();
}
