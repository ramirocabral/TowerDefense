import entregable.Comparators.*;
import game.components.GameDrawException;
import game.components.Monster;
import game.components.RumbleGame;
import game.monsters.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import entregable.monstruos.*;

import static java.lang.Thread.sleep;

import static java.lang.System.exit;


public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(new HolyKnight("HolyKnight"),
         new HolyKnight("MATEO AYUDAME LOCOOOO"));

        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(new Spartan("spartan"));

        Collections.sort(monstersTwo, new NumberOfTypesComparator());


        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);
        try {
            rumbleGame.startGame();
        }catch (GameDrawException e){
            System.out.println("MANU TARADO!!!!!");
            exit(0);
            try {
                sleep(1500);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        try{Thread.sleep(5000);}
        catch (InterruptedException e){
            e.printStackTrace();
        }
        exit(0);
    }
}