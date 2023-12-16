package entregable.ataques.Venom;

import game.components.Monster;
import game.random.RandomGenerator;

public class PoisonCover implements Venom{
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(130, 240);
        return (damage);
    }
    @Override
    public int getMinDamage(){
        return 230;
    }
    @Override
    public int getMaxDamage(){
        return 440;
    }
}
