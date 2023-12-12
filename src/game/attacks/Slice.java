package game.attacks;

import entregable.ataques.Multipliers;
import game.components.Monster;
import game.random.RandomGenerator;

public class Slice implements Sword {

    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(100, 500);
        return (int)(damage* Multipliers.SWORD.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMinDamage(){return 100;}
    @Override
    public int getMaxDamage(){return 500;}
}
