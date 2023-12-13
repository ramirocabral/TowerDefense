package entregable.ataques.Psychic;
import entregable.ataques.Multipliers;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class Mindcrush implements Psychic{
    @Override
    public int damage(Monster monster) {
        int damage = RandomGenerator.getInstance().calculateDamage(300, 500);
        damage *= Multipliers.PSYCHIC.getMultiplier(monster.getTypes().get(0));
        return damage;
    }

    @Override
    public int getMinDamage(){return 300;}

    @Override
    public int getMaxDamage(){
        return 500;
    }
}
