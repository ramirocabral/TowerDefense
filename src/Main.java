import entregable.Comparators.*;
import game.components.Monster;
import game.components.RumbleGame;
import game.monsters.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import entregable.monstruos.*;


public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(new HolyKnight("HolyKnight"),
                new Blob("Blob"),
                new ElectroBOOM("ElectroBOOM"),
                new HolyKnight("HolyKnight2"));

        Collections.sort(monstersOne, new NumberOfTypesComparator());

        //TODO ordenar el listado de monstruos que recibe el jugador uno
        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(new Spartan("spartan"),
                new Ninja("Ninja"),
                new Golem("Golem"),
                new EvilBeast("EvilBeast"));

        Collections.sort(monstersTwo, new NumberOfTypesComparator());

        //TODO ordenar el listado de monstruos que recibe el jugador dos
        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);

        rumbleGame.startGame();
    }
}