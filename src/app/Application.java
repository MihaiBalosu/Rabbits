package app;

import controller.Controller;
import game.GameFactory;
import game.GameFactoryRole;
import io.Output;
import io.OutputRole;

import java.awt.*;

public class Application {

    public static void main(String[] args) {

        OutputRole output = new Output();
        GameFactoryRole gameFactory = new GameFactory(output);
        Controller controller = new Controller(gameFactory);
        EventQueue.invokeLater(() -> {
            controller.startGame();
        });

    }
}
