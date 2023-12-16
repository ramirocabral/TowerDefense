package entregable.ataques.Electric;

import entregable.ataques.Multipliers;
import game.components.Monster;
import game.random.RandomGenerator;
public class Discharge implements Electric {
    //pega x1.7 a water y cold
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(120, 170);
        return (int) (damage * Multipliers.ELECTRIC.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMinDamage(){ return 120;}

    @Override
    public int getMaxDamage(){return 170;}
}
