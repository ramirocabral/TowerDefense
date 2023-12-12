package game.components;

public class GameDrawException extends InterruptedException  {
    public GameDrawException(String message) {
        super(message);
    }
}