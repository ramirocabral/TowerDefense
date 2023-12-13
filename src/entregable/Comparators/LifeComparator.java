package entregable.Comparators;

import game.components.Monster;

import java.util.Comparator;

public class LifeComparator implements Comparator<Monster> {
    @Override
    public int compare(Monster monster1, Monster monster2){
        return monster2.getLife() - monster1.getLife();
    }
}
