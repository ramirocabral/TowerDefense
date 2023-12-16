package game.components;


public class TieException extends Exception  {
    public TieException() {}

    public TieException(Exception e) {
        super(e);
    }
    public TieException(String message) {
        System.out.println(message);
    }

    //Capaz hay que agregar algo o mejorarlo
}