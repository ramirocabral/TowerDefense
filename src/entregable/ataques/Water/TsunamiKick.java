package entregable.ataques.Water;

import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class TsunamiKick implements Water{
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(100, 140);
        if(monster.getTypes().contains(Type.FIRE)) {
            damage = damage * 2;
        }
        return damage;
    }
}
