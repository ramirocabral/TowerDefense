package entregable.Comparators;

import game.components.Monster;

import java.util.Comparator;

/*
 * Comparador de cantidad de tipos de los monstruos. Dado que los monstruos pueden tener más de un tipo, aquel
 * monstruo con más tipos será el que se encuentre primero en la "lista".
 * */
public class NumberOfTypesComparator implements Comparator<Monster> {
    @Override
    public int compare(Monster monster1, Monster monster2) {
        return -Integer.compare(monster1.getTypes().size(), monster2.getTypes().size());
    }

}
