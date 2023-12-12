package game.attacks;

import entregable.ataques.Multipliers;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class ColdBreath implements Cold {
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(90, 150);
        return (int) (damage * Multipliers.COLD.getMultiplier(monster.getTypes().get(0)));
    }
    @Override
    public int getMinDamage(){return 90;}
    @Override
    public int getMaxDamage(){return 150;}
}
