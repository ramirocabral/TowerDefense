package entregable.Comparators;

import game.components.Monster;

import java.util.Comparator;

/*
* Comparador de daño promedio de los monstruos. Aquel monstruo con más daño promedio será el que se encuentre
* primero en la "lista".
* */

public class DamageComparator implements Comparator<Monster> {
    @Override
    public int compare(Monster monster1, Monster monster2){
        return -Double.compare(monster1.getAverageDamage(), monster2.getAverageDamage());
    }
}
