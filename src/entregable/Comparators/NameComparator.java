package entregable.Comparators;

import game.components.Monster;

import java.util.Comparator;

/*
 * Comparador de tipos principales de los monstruos. La "lista" se ordenara por orden alfabetico de
 * los nombres de los monstruos.
 * */
public class NameComparator implements Comparator<Monster> {
    @Override
    public int compare(Monster monster1, Monster monster2){
        return monster1.toString().compareTo(monster2.toString());
    }


}