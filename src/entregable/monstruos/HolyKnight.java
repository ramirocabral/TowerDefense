package entregable.monstruos;
import entregable.ataques.Radiant.*;
import game.attacks.ColdBreath;
import game.components.Monster;
import game.attacks.Attack;
import game.attacks.Slice;
import game.components.PathBox;
import game.types.Type;
import java.util.Arrays;
import java.util.List;


public class HolyKnight extends Monster {
    //Es Radiant y Sword
    //Le hace counter a Demon y Arrow
    private List<Attack> skills = Arrays.asList(new Slice(), new HolyLight());

    public HolyKnight(String name) {
        this.life = 510;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.SWORD,Type.RADIANT);
    }

    @Override
    public void attack(Monster enemy) {
        if (enemy.getTypes().contains(Type.DEMON)){
            this.activeSkill = skills.get(1);
        }
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
        this.activeSkill = skills.get(0);
    }

}