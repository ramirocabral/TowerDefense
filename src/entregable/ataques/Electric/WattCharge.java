package entregable.ataques.Electric;

import game.components.Monster;
import game.random.RandomGenerator;

public class WattCharge implements Electric {
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(100, 150);
        return (damage);
    }
    @Override
    public int getMinDamage(){
        return 100;
    }
    @Override
    public int getMaxDamage(){
        return 150;
    }
}
