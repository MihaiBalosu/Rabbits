package io;

import game.GameFactoryRole;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input implements InputRole {

    private Scanner scanner;
    private GameFactoryRole gameFactory;
    
 
    public Input(GameFactoryRole anotherGameFactory) throws FileNotFoundException {
        this.gameFactory = anotherGameFactory;
    	File file = new File("E:\\Java\\RabbitsGUI\\Data.txt");
    	scanner = new Scanner(file);
	}

	@Override
    public void readFieldDimensions() {
        int length = scanner.nextInt();
      //  gameFactory.createField(length, columns);
    }

    @Override
    public void readPrizesPositions() {
        int noOfEggs = scanner.nextInt();
        for(int i = 0; i < noOfEggs; i++){
            int x =  scanner.nextInt();
            int y = scanner.nextInt();
            int value = scanner.nextInt();

            gameFactory.addLifePoints(x, y, value);
        }

    }

    @Override
    public void readPlayersPositions() {
        int noOfPlayers = scanner.nextInt();
        for(int i = 0; i < noOfPlayers; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            gameFactory.addPlayer(x, y);
        }

    }
}
