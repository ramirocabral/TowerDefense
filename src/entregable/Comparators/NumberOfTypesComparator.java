package entregable.Comparators;

import game.components.Monster;

import java.util.Comparator;

public class NumberOfTypesComparator implements Comparator<Monster> {
    @Override
    public int compare(Monster monster1, Monster monster2) {
        return -Integer.compare(monster1.getTypes().size(), monster2.getTypes().size());
    }

}
