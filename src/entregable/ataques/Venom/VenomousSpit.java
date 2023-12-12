package entregable.ataques.Venom;
import game.attacks.Attack;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class VenomousSpit implements Venom{
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(60, 90);
        if(monster.getTypes().contains(Type.SWORD)) {
            damage = (int)(damage * 1.7);
        }
        return damage;
    }
}