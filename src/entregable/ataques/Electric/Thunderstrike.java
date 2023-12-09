package entregable.ataques.Electric;

import entregable.ataques.Electric.Electric;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class Thunderstrike implements Electric {

    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(90, 140);
        if(monster.getTypes().contains(Type.WATER) || (monster.getTypes().contains(Type.COLD))) {
            damage = (int)(damage * 1.2);
        }
        return damage;
    }

}
