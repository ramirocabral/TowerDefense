package entregable.ataques.Fire;

import entregable.ataques.Multipliers;
import game.components.Monster;


public class Flamethrower implements Fire{
    @Override
    public int damage(Monster monster) {
        int damage = 100;
        return (int)(damage* Multipliers.FIRE.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMaxDamage() {return 100;}
    @Override
    public int getMinDamage(){return 100;}
}