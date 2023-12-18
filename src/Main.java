import entregable.Comparators.*;
import entregable.UI.InitialImage;
import entregable.UI.Result;
import entregable.monstruos.*;
import game.components.Monster;
import game.monsters.*;
import game.components.RumbleGame;
import game.components.TieException;

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
        
        /*
            Player One (Blue)
        * */

        List<Monster> monstersOne = Arrays.asList(
                new AbyssWalker("AbyssWalker1"),
                new Blaze("Blaze1"),
                new Blob("Blob1"),
                new Cadabra("Cadabra1"),
                new Cleric("Cleric1"),
                new CrowApostate("CrowApostate1"),
                new ElectroBOOM("ElectroBOOM1"),
                new Golem("Golem1"),
                new HolyKnight("HolyKnight1"),
                new Ninja("Ninja1"),
                new Siren("Siren1"),
                new IceBeast("IceBeast1"),
                new CrowApostate("CrowApostate1"),
                new Spartan("Spartan1"),
                new EvilBeast("EvilBeast1")
                );

        Collections.sort(monstersOne, new DamageComparator());

        /*
            Player Two (Red)
        * */

        rumbleGame.getPlayerOne().setMonsters(monstersOne);
        List<Monster> monstersTwo = Arrays.asList(
                new AbyssWalker("AbyssWalker2"),
                new Blaze("Blaze2"),
                new Blob("Blob2"),
                new Cadabra("Cadabra2"),
                new Cleric("Cleric2"),
                new CrowApostate("CrowApostate2"),
                new ElectroBOOM("ElectroBOOM12"),
                new Golem("Golem2"),
                new HolyKnight("HolyKnight2"),
                new Ninja("Ninja2"),
                new Siren("Siren2"),
                new IceBeast("IceBeast2"),
                new CrowApostate("CrowApostate2"),
                new Spartan("Spartan2"),
                new EvilBeast("EvilBeast2")
        );

        Collections.sort(monstersTwo, new HealthComparator());
        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);

        try {
            rumbleGame.startGame();
        }catch (TieException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            Result resultUI = new Result(rumbleGame.getPlayerOne().getCastle().getLife(), rumbleGame.getPlayerTwo().getCastle().getLife(), rumbleGame.getRound());
            resultUI.setVisible(true);
        }
    }

}