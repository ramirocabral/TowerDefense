import entregable.monstruos.ElectroBOOM;
import entregable.monstruos.Golem;
import entregable.monstruos.HolyKnight;
import entregable.monstruos.Ninja;
import game.components.Monster;
import game.components.RumbleGame;
import game.monsters.EvilBeast;
import game.monsters.IceBeast;
import game.monsters.Spartan;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(new Spartan("Spartan 1"),
                new EvilBeast("EvilBeast"),
                new ElectroBOOM("ElectroBOOM"),
                new Ninja("Ninja"),
                new Spartan("Spartan 15"));

        //TODO ordenar el listado de monstruos que recibe el jugador uno
        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(new Spartan("Spartan A"),
                new Spartan("Spartan B"),
                new Golem("La gorda de la mama de mateo"),
                new Golem("La gorda de la mama de mateo"),
                new Golem("La gorda de la mama de mateo"),
                new Golem("La gorda de la mama de mateo"),
                new HolyKnight("Javier Milei"));

        //TODO ordenar el listado de monstruos que recibe el jugador dos
        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);

        rumbleGame.startGame();
    }
}