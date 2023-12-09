package entregable.ataques.Psychic;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class Mindcrush implements Psychic{
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(300, 500);
        if(monster.getTypes().contains(Type.BEAST)){
            damage = 1;
        }
        if(monster.getTypes().contains(Type.ELECTRIC) || monster.getTypes().contains(Type.FIRE) || monster.getTypes().contains(Type.COLD) || monster.getTypes().contains(Type.WATER)){
            damage = damage = (int)(damage * 1.5);
        }
        return damage;
    }
}
