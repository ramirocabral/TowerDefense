package game.components;

import entregable.Comparators.NumberOfTypesComparator;
import entregable.UI.Result;
import entregable.monstruos.*;
import game.monsters.EvilBeast;
import game.monsters.Spartan;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {
    public static void game(){
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(
                new Golem("Golem"),
                new HolyKnight("Caballero"),
                new Cadabra("Cadabra"),
                new Ninja("Ninja")
        );
        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(
                new EvilBeast("Vaca"),
                new ElectroBOOM("Vaca"),
                new Spartan("Vaca")
        );
        Collections.sort(monstersTwo, new NumberOfTypesComparator());
        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);

        try {
            rumbleGame.startGame();
            //movido desde RumbleGame para no romper el encapsulamiento
            Result resultUI = new Result(rumbleGame.getPlayerOne().getCastle().getLife(), rumbleGame.getPlayerTwo().getCastle().getLife(), rumbleGame.getRound());
            resultUI.setVisible(true);
        }catch (TieException e){
            System.exit(0);
        }
    }
}
