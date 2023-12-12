package entregable.ataques.Radiant;

import entregable.ataques.Multipliers;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class HolyLight implements Radiant {
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(200, 300);
        return (int) (damage * Multipliers.RADIANT.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMaxDamage() {return 300;}
    @Override
    public int getMinDamage(){return 200;}
}
