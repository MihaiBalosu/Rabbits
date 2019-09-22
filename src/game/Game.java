package game;

import field.FieldRole;
import io.OutputRole;
import player.PlayerRole;

import java.io.Serializable;
import java.util.List;

public class Game implements GameRole, Serializable {

    private FieldRole field;
    private int noOfTurns;
    private OutputRole output;

    public Game(FieldRole otherField, OutputRole otherOutput) {
        this.field = otherField;
        this.output = otherOutput;
    }

    @Override
    public void play() {
        field.movePlayers();
        field.moveEnemies();
        noOfTurns++;

    }

    @Override
    public void getWinner() {
        output.add("Winner is player with number " + field.getWinner().getIndex());
    }

    @Override
    public String getOutput() {
        List<PlayerRole> allPlayers = field.getAllPlayer();
        for (PlayerRole player : allPlayers) {
            output.add("player " + player.getIndex() + " has " + player.getScore() + " points");
        }
        getWinner();
        output.add("Number of turns: " + noOfTurns);
        return output.getOutput();
    }

    @Override
    public boolean isPlayable() {
        return field.hasPlayers();
    }

    public List<PlayerRole> getPlayersInField() {
        return field.getPlayersOnField();
    }

    public List<PlayerRole> getAllPlayers() {
        return field.getAllPlayer();
    }

}
