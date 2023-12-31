package entregable.ataques.Water;

import entregable.ataques.Multipliers;
import game.components.Monster;
import game.random.RandomGenerator;

public class TsunamiPunch implements Water{
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(120, 150);
        return (int)(damage* Multipliers.WATER.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMinDamage(){ return 120;}

    @Override
    public int getMaxDamage(){ return 150;}
}
