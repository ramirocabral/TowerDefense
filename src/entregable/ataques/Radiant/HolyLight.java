package entregable.ataques.Radiant;

import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class HolyLight implements Radiant {
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(200, 300);
        return damage;
    }
}
