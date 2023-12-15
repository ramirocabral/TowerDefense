package entregable.monstruos;
import entregable.ataques.Electric.Discharge;
import entregable.ataques.Water.KangarooKick;
import entregable.ataques.Water.TsunamiPunch;
import game.components.Monster;
import game.components.PathBox;
import game.random.RandomGenerator;
import game.attacks.Attack;
import game.types.Type;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;


public class Ninja extends Monster {
    private List<Attack> skills = Arrays.asList(new TsunamiPunch() , new KangarooKick());
    public Ninja(String name) {
        this.life = 500;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.WATER);
        this.image = new ImageIcon("assets/monsters/samurai.png");
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

    //rotamos las habilidades
    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        super.move(oldPathBox, newPathBox);
        if(activeSkill instanceof TsunamiPunch) {
            this.activeSkill = skills.get(1);
        } else {
            this.activeSkill = skills.get(0);
        }
    }

}