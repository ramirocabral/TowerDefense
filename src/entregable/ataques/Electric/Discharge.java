package entregable.ataques.Electric;

import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class Discharge implements Electric {
    //pega x1.7 a water y cold
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(110, 150);
        if(monster.getTypes().contains(Type.WATER) || (monster.getTypes().contains(Type.COLD))) {
            damage = (int)(damage * 1.7);
        }
        return damage;
    }
}
