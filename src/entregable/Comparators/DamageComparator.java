package entregable.Comparators;

import game.components.Monster;

import java.util.Comparator;

public class DamageComparator implements Comparator<Monster> {
    @Override
    public int compare(Monster monster1, Monster monster2){
        return Double.compare(monster1.getAverageDamage(), monster2.getAverageDamage());
    }
}
