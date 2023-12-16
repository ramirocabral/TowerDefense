package entregable.monstruos;

import entregable.ataques.Demon.VoidSlash;
import entregable.ataques.Venom.PoisonCover;
import game.attacks.Attack;
import game.components.Monster;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class AbyssWalker extends Monster{


    private List<Attack> skills = Arrays.asList(new VoidSlash(), new PoisonCover());
    private final int DAMAGEMAX = 400;
    private int  DamageMeter = 0;
    public AbyssWalker(String name) {
        this.life = 800;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.DEMON, Type.SWORD);
        this.image = new ImageIcon("assets/monsters/AbyssWalker.png");
    }

    @Override
    public void attack(Monster enemy) {
        int damage;
        if(this.life < 200){
            damage = this.activeSkill.damage(this);
            System.out.println("--     ["+ this +"] se cura " + damage + " de vida");
            this.life = this.life + damage;
        }else {
            damage = this.activeSkill.damage(enemy);
            DamageMeter += damage;
            if (DamageMeter >= DAMAGEMAX) {
                damage = damage + DamageMeter;
                DamageMeter = 0;
                System.out.println("El medidor de daño se lleno, el ataque de [" + this + "] se potencia");
            }
            System.out.println("--     [" + this + "] ataca a [" + enemy + "] haciendole " + damage + " de daño");
            enemy.onDamageReceive(damage, this);
        }
    }
}
