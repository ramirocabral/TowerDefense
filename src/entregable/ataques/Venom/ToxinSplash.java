package entregable.ataques.Venom;

import game.components.Monster;
import game.random.RandomGenerator;
import game.attacks.Attack;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class ToxinSplash implements Venom{
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(230, 440);
        return damage;
    }
}
