package entregable.ataques.Demon;

import entregable.ataques.Multipliers;
import game.attacks.Demon;
import game.components.Monster;
import game.random.RandomGenerator;

public class VoidSlash implements Demon {
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(100, 120);
        return (int)(damage* Multipliers.DEMON.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMinDamage(){ return 100;}

    @Override
    public int getMaxDamage() {return 140;}
}
