package entregable.Comparators;

import game.components.Monster;

import java.util.Comparator;

public class TypeComparator implements Comparator<Monster> {
    @Override
    //Compara por el tipo principal, el cual suponemos que esta en la primer posicion de la lista de tipos
    public int compare(Monster monster1, Monster monster2) {
        return Integer.compare(monster1.getTypes().get(0).ordinal(), monster2.getTypes().get(0).ordinal());
    }
}
