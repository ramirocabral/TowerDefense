package entregable.ataques.Water;

import entregable.ataques.Multipliers;
import game.components.Monster;
import game.random.RandomGenerator;

public class KangarooKick implements Water{
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(150, 200);
        return (int)(damage* Multipliers.WATER.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMinDamage(){ return 150;}

    @Override
    public int getMaxDamage(){ return 200;}
}
