package entregable.ataques.Fire;

import entregable.ataques.Multipliers;
import game.components.Monster;
import game.random.RandomGenerator;

public class FireBall implements Fire{
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(90, 250);
        return (int)(damage* Multipliers.FIRE.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMaxDamage() {return 90;}
    @Override
    public int getMinDamage(){return 250;}
}