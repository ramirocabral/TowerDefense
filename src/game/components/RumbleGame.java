package game.components;

import entregable.UI.Result;
import game.random.RandomGenerator;


public class RumbleGame {

    private static RumbleGame instance = new RumbleGame();
    private Player playerOne;
    private Player playerTwo;
    private boolean loopGame = true;
    private int round = 0;
    private SegundaEvaluacionUI segundaEvaluacionUI;

    private Result resultUI;

    public static RumbleGame getInstance() {
        return instance;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public int getRound(){
        return this.round;
    }

    private RumbleGame() {

    }

    public void init() {
        playerOne = new Player(1L);
        playerTwo = new Player(2L);

        Castle castleOne = new Castle();
        Castle castleTwo = new Castle();

        Path westPath = new Path();
        Path eastPath = new Path();

        castleOne.setEastPath(eastPath);
        castleOne.setWestPath(westPath);

        castleTwo.setEastPath(eastPath);
        castleTwo.setWestPath(westPath);

        playerOne.setCastle(castleOne);
        playerTwo.setCastle(castleTwo);


        segundaEvaluacionUI = new SegundaEvaluacionUI();
        segundaEvaluacionUI.init().setVisible(true);


        PathBox box3 = new PathBox(segundaEvaluacionUI.getButton(0),segundaEvaluacionUI.getHealthBar(0), "Noroeste");
        PathBox box6 = new PathBox(segundaEvaluacionUI.getButton(2),segundaEvaluacionUI.getHealthBar(2), "Oeste");
        PathBox box9 = new PathBox(segundaEvaluacionUI.getButton(4),segundaEvaluacionUI.getHealthBar(4), "Suroeste");

        //noroeste
        box3.setNorthBox(null);
        box3.setSouthBox(box6);

        box6.setNorthBox(box3);
        box6.setSouthBox(box9);

        //suroeste
        box9.setNorthBox(box6);
        box9.setSouthBox(null);

        westPath.getPathBoxes().add(box3);
        westPath.getPathBoxes().add(box6);
        westPath.getPathBoxes().add(box9);

        PathBox box5 = new PathBox(segundaEvaluacionUI.getButton(1),segundaEvaluacionUI.getHealthBar(1), "Noreste");
        PathBox box8 = new PathBox(segundaEvaluacionUI.getButton(3),segundaEvaluacionUI.getHealthBar(3), "Este");
        PathBox box11 = new PathBox(segundaEvaluacionUI.getButton(5),segundaEvaluacionUI.getHealthBar(5), "Sureste");


        //noreste
        box5.setNorthBox(null);
        box5.setSouthBox(box8);

        box8.setNorthBox(box5);
        box8.setSouthBox(box11);

        box11.setNorthBox(box8);
        box11.setSouthBox(null);

        eastPath.getPathBoxes().add(box5);
        eastPath.getPathBoxes().add(box8);
        eastPath.getPathBoxes().add(box11);

        castleOne.setLifeLabels(segundaEvaluacionUI.getVidasPlayerOneLabel());
        castleTwo.setLifeLabels(segundaEvaluacionUI.getVidasPlayerTwoLabel());
        //
    }


    public void nextRound() throws TieException {
        System.out.println();
        System.out.println();
        System.out.println("Siguiente Ronda numero: " + round);
        // seleccionamos uno de los dos jugadores, al azar
        int jugador = RandomGenerator.getInstance().nextPlayer();
        System.out.println("Mueve primero el Jugador numero " + jugador);
        if(jugador == 1) {
            playerOne.nextRound();
            playerTwo.nextRound();
        } else {
            playerTwo.nextRound();
            playerOne.nextRound();
        }
        segundaEvaluacionUI.refresh();
        round++;
        if(playerOne.getCastle().getCastleLife() <= 0) {
            System.out.println("****         Ganador el Jugador Azul!!!         ****");
            loopGame = false;
        }
        if(playerTwo.getCastle().getCastleLife() <= 0) {
            System.out.println("****         Ganador el Jugador Rojo!!!         ****");
            loopGame = false;
        }
        if(round == 100) {
            loopGame = false;
            throw new TieException("¡Empate por llegar a 100 rondas!");
        }
        if (loopGame && !checkMonsters()) {
            loopGame = false;
            throw new TieException("¡Empate por falta de monstruos!");
        }
    }

    public boolean checkMonsters() {
        Path westPlayerOne = playerOne.getCastle().getWestPath();
        Path eastPlayerOne = playerOne.getCastle().getEastPath();
        Path westPlayerTwo = playerTwo.getCastle().getWestPath();
        Path eastPlayerTwo = playerTwo.getCastle().getEastPath();
        return (playerOne.hasNextMonster() || playerTwo.hasNextMonster() || (westPlayerOne.haveMonster(playerOne.getId()) || eastPlayerOne.haveMonster(playerOne.getId())
        || westPlayerTwo.haveMonster(playerTwo.getId()) || eastPlayerTwo.haveMonster(playerTwo.getId())));
    }

    public void startGame() throws TieException {
        while(loopGame) {
            try {
                Thread.sleep(1500);
                this.nextRound();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            catch(TieException e) {
                throw new TieException(e.getMessage());
            }
        }
    }
}