package game.attacks;

import entregable.ataques.Multipliers;
import game.components.Monster;
import game.random.RandomGenerator;

public class IceSpike implements Cold {

    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(100, 200);
        return (int)(damage* Multipliers.COLD.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMinDamage() {return 100;}
    @Override
    public int getMaxDamage(){return 200;}
}
