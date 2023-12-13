package entregable.ataques.Venom;

import entregable.ataques.Multipliers;
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
        return (int)(damage* Multipliers.VENOM.getMultiplier(monster.getTypes().get(0)));
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