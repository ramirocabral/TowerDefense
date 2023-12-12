import entregable.Comparators.*;
import game.components.Monster;
import game.components.RumbleGame;
import game.components.TieException;
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

        List<Monster> monstersOne = Arrays.asList(new HolyKnight("AgusMurray"));

        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(new EvilBeast("Vaca"));

        Collections.sort(monstersTwo, new NumberOfTypesComparator());

        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);
        try {
            rumbleGame.startGame();
        }catch (TieException e){
            System.exit(0);
        }

//        try{Thread.sleep(5000);}
//        catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        System.exit(0);

    }
}