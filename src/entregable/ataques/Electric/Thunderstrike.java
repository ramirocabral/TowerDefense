package entregable.ataques.Electric;

import entregable.ataques.Multipliers;
import game.components.Monster;
import game.random.RandomGenerator;

public class Thunderstrike implements Electric {

    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(200, 500);
        return (int) (damage* Multipliers.ELECTRIC.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMinDamage(){
        return 200;
    }
    @Override
    public int getMaxDamage(){ return 500;}

}
