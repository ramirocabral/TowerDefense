package entregable.ataques.Venom;

import entregable.ataques.Multipliers;
import game.components.Monster;
import game.random.RandomGenerator;

public class VenomousSpit implements Venom{
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(60, 90);
        return (int)(damage* Multipliers.VENOM.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMinDamage(){ return 60;}

    @Override
    public int getMaxDamage() {return 90;}
}