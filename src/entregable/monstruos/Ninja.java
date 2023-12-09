package entregable.monstruos;
import entregable.ataques.Water.TsunamiKick;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;
import java.util.Arrays;



public class Ninja extends Monster {
    public Ninja(String name) {
        this.life = 500;
        this.activeSkill = new TsunamiKick();
        this.monsterName = name;
        this.types = Arrays.asList(Type.WATER);
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }

    // tiene 30% de chance que no le peguen
    @Override
    public void onDamageReceive(Integer damage, Monster monster) {
        int probability = RandomGenerator.getInstance().calculateDamage(0,100);
        if (probability <= 30)
            damage = 0;
        this.life = this.life - damage;
        if(this.life < 0) {
            this.life = 0;
        }
        System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida");
    }
}