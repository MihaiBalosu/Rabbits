package field;

import io.OutputRole;
import parcel.ParcelRole;
import player.EnemyRole;
import player.PlayerRole;
import player.RabbitWithHealth;
import position.PositionRole;
import position.PositionStateRole;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Field implements FieldRole, Serializable {

    private List<PlayerRole> playersOnFieldList, playersForOutputList;
    private ParcelRole[][] parcels;
    private OutputRole output;
    private List<EnemyRole> enemyOnFieldList;

    public Field(OutputRole otherOutput) {
        this.output = otherOutput;
        playersForOutputList = new ArrayList<>();
    }

    @Override
    public boolean hasPlayers() {
        return playersOnFieldList.isEmpty() == false;
    }

    @Override
    public void movePlayers() {
        List<PlayerRole> copyList = new ArrayList<PlayerRole>(playersOnFieldList);
        for (PlayerRole player : copyList) {
            player.turn();
        }
    }

    @Override
    public void visitByPlayerWithHealth(PositionRole positionState, PlayerRole player) {
        ParcelRole parcel = parcels[positionState.getX()][positionState.getY()];
        parcel.visitedBy(player);
    }

    @Override
    public void endGameFor(PlayerRole player) {
        playersOnFieldList.remove(player);
    }

    @Override
    public PlayerRole getWinner() {
        PlayerRole winner = playersForOutputList.get(0);
        for (PlayerRole player : playersForOutputList) {
            if (player.getScore() > winner.getScore()) {
                winner = player;
            }
        }
        return winner;
    }

    @Override
    public void setParcels(ParcelRole[][] otherParcels) {
        parcels = otherParcels;
    }

    @Override
    public void visitByPlayerWithHealth(PositionStateRole positionState, RabbitWithHealth rabbitWithHealth) {
        ParcelRole parcel = parcels[positionState.getX()][positionState.getY()];
        parcel.visitPlayerWithHealth(rabbitWithHealth);
    }

    @Override
    public List<PlayerRole> getPlayersOnField() {
        return playersOnFieldList;
    }

    @Override
    public void setPlayersOnField(List<PlayerRole> otherPlayers) {
        for (PlayerRole player : otherPlayers) {
            if (!playersForOutputList.contains(player)) {
                playersForOutputList.add(player);
            }
        }
        this.playersOnFieldList = otherPlayers;

    }

    @Override
    public List<PlayerRole> getAllPlayer() {
        return playersForOutputList;
    }

    @Override
    public void seEnemies(List<EnemyRole> enemies) {
        enemyOnFieldList = enemies;
    }

    @Override
    public void visitByEnemy(PlayerRole player, EnemyRole fox) {
        ParcelRole parcel = parcels[fox.getX()][fox.getY()];
        parcel.visitedByEnemy(player, fox);
    }

    @Override
    public void endGameFor(EnemyRole fox) {
        enemyOnFieldList.remove(fox);
    }

    @Override
    public List<EnemyRole> getEnemies() {
        return enemyOnFieldList;
    }

    @Override
    public void moveEnemies() {
        List<PlayerRole> copyList = new ArrayList<PlayerRole>(playersOnFieldList);
        List<EnemyRole> enemiesCopy = new ArrayList<>(enemyOnFieldList);
        for (EnemyRole enemy : enemiesCopy) {
            enemy.turn(copyList);
        }
    }

}
