package entregable.ataques.Fire;

import entregable.ataques.Multipliers;
import game.attacks.Fire;
import game.components.Monster;

public class FireNova implements Fire {
    @Override
    public int damage(Monster monster) {
        int damage = 999;
        return (int) (damage * Multipliers.FIRE.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMaxDamage() {
        return 999;
    }

    @Override
    public int getMinDamage() {
        return 999;
    }
}
