package entregable.Comparators;

import game.components.Monster;

import java.util.Comparator;

/*
 * Comparador de tipos principales de los monstruos (el tipo principal es el primero en la lista de tipos de cada mounstro).
 * Aquel monstruo con tipo principal más fuerte (aquel que tenga menor ordinal) será el que se encuentre primero en la "lista".
 * */
public class MainTypeComparator implements Comparator<Monster> {
    @Override
    //Compara por el tipo principal, el cual suponemos que esta en la primer posicion de la lista de tipos
    public int compare(Monster monster1, Monster monster2) {
        return Integer.compare(monster1.getTypes().get(0).ordinal(), monster2.getTypes().get(0).ordinal());
    }
}
