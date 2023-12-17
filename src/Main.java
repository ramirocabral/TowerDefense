import entregable.Comparators.NumberOfTypesComparator;
import entregable.UI.InitialImage;
import entregable.UI.Result;
import entregable.monstruos.*;
import game.components.Monster;
import game.components.RumbleGame;
import game.components.TieException;
import game.monsters.EvilBeast;
import game.monsters.IceBeast;
import game.monsters.Spartan;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        InitialImage initialImage = new InitialImage();
        initialImage.setVisible(true);

        // Espera hasta que el boton de start sea presionado
        while (!initialImage.isStartPressed()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        game();
    }
    public static void game(){
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(
                new EvilBeast("EvilBeast"),
                new ElectroBOOM("ElectroBOOM"),
                new AbyssWalker("AbyssWalker"),
                new Blob("Blob"),
                new Spartan("Spartan"),
                new IceBeast("IceBeast"),
                new Ninja("Ninja"),
                new Blaze("Blaze")
        );

        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(
                new Siren("Siren"),
                new CrowApostate("crow"),
                new Cadabra("Cadabra"),
                new Ninja("Ninja"),
                new Golem("Golem"),
                new Cleric("Cleric"),
                new HolyKnight("HolyKnight")
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
