import entregable.Comparators.NumberOfTypesComparator;
import entregable.UI.InitialImage;
import entregable.UI.Result;
import entregable.monstruos.AbyssWalker;
import game.components.Monster;
import game.components.RumbleGame;
import game.components.TieException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        InitialImage initialImage = new InitialImage();
        initialImage.setVisible(true);

        // Wait until the "Start" button is pressed
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
                new AbyssWalker("Nashe"),
                new AbyssWalker("Nashe2"),
                new AbyssWalker("Nashe3")

        );
        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(

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
