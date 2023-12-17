package game.components;

/*
   Excepcion de Empate personalizada. Extiende de RuntimeException para el empate solo se verifique en tiempo de
   ejecucion (debido que solo alli puede darse).
* */

public class TieException extends RuntimeException  {
    public TieException() {}
    public TieException(Exception e) {
        super(e);
    }
    public TieException(String message) { super(message);}


}