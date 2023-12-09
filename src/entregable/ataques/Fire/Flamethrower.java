package entregable.ataques.Fire;

import game.components.Monster;
import game.types.Type;

public class Flamethrower  implements Fire{
    @Override
    public int damage(Monster monster) {
        int damage = 80;
        if(monster.getTypes().contains(Type.COLD)) {
            damage = (int)(damage * 1.7);
        }
        return damage;
    }
}