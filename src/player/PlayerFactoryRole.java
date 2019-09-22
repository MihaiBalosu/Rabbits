package player;

public interface PlayerFactoryRole {
    Rabbit buildPlayer();

    RabbitWithHealth buildPlayerWithLifes(Life health);

}
