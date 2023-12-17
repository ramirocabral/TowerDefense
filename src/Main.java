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
                new Ninja("Ninja1"),
                new Siren("Siren1")
        );

        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(
                new Golem("Golem1"),
                new Golem("Golem2")
        );
        Collections.sort(monstersTwo, new NumberOfTypesComparator());
        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);

        try {
            rumbleGame.startGame();
            //Movido desde RumbleGame para no romper el encapsulamiento
            Result resultUI = new Result(rumbleGame.getPlayerOne().getCastle().getLife(), rumbleGame.getPlayerTwo().getCastle().getLife(), rumbleGame.getRound());
            resultUI.setVisible(true);
        }catch (TieException e){
            Result resultUI = new Result(rumbleGame.getPlayerOne().getCastle().getLife(), rumbleGame.getPlayerTwo().getCastle().getLife(), rumbleGame.getRound());
            resultUI.setVisible(true);
        }
    }
}