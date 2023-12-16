package entregable.monstruos;

import entregable.ataques.Venom.ToxinSplash;
import entregable.ataques.Venom.VenomousSpit;
import game.attacks.Attack;
import game.components.Monster;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Blob extends Monster{

    private List<Attack> skills = Arrays.asList(new VenomousSpit(), new ToxinSplash());

    public Blob(String name) {
        this.life = 350;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.VENOM);
        this.image = new ImageIcon("assets/monsters/blob.png");
    }

    @Override
    public void attack(Monster enemy) {

        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }
    @Override
    public void onDamageReceive(Integer damage, Monster monster) {
        this.life = this.life - damage;
        if(this.life < 0) {
            this.life = 0;
            this.activeSkill = skills.get(1);
            attack(monster);
        }
        System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida");
    }
}
