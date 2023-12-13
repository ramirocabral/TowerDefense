package entregable.ataques.Fire;

import entregable.ataques.Multipliers;
import game.components.Monster;
import game.types.Type;


public class Flamethrower  implements Fire{
    @Override
    public int damage(Monster monster) {
        int damage = 80;
        return (int)(damage* Multipliers.FIRE.getMultiplier(monster.getTypes().get(0)));
    }

    @Override
    public int getMaxDamage() {return 80;}
    @Override
    public int getMinDamage(){return 80;}
}