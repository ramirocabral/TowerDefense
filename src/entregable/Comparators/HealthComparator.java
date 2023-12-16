package entregable.Comparators;

import game.components.Monster;

import java.util.Comparator;

/*
 * Comparador de la vida de los monstruos. Aquel monstruo con más vida será el que se encuentre primero en la "lista".
 * */
public class HealthComparator implements Comparator<Monster> {
    @Override
    public int compare(Monster monster1, Monster monster2){
        return monster2.getLife() - monster1.getLife();
    }
}
