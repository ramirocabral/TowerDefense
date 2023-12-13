import entregable.Comparators.*;
import entregable.InitialImage;
import entregable.Result;
import game.components.Monster;
import game.components.RumbleGame;
import game.components.TieException;
import game.monsters.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import entregable.monstruos.*;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

//        SwingUtilities.invokeLater(InitialImage::new);

        game();

//        try{Thread.sleep(5000);}
//        catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        System.exit(0);
    }

    public static void game(){
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(new HolyKnight("AgusMurray"));

        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(new EvilBeast("Vaca"),
        new EvilBeast("Vaca"),
                new EvilBeast("Vaca"),
                new EvilBeast("Vaca"),
        new EvilBeast("Vaca"),
        new EvilBeast("Vaca"));

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
