package entregable.ataques.Sword;

import entregable.ataques.Multipliers;
import entregable.ataques.Venom.Venom;
import game.components.Monster;
import game.random.RandomGenerator;

public class BladeSlash implements Sword {

    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(100, 140);
        return (int)(damage* Multipliers.SWORD.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMinDamage(){ return 100;}

    @Override
    public int getMaxDamage() {return 140;}
}