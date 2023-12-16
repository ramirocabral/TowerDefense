package entregable.monstruos;

import entregable.ataques.Radiant.HolyLight;
import game.attacks.Attack;
import game.attacks.Slice;
import game.components.Monster;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;


public class HolyKnight extends Monster {
    //Es Radiant y Sword
    //Le hace counter a Demon y Arrow
    private List<Attack> skills = Arrays.asList(new Slice(), new HolyLight());

    public HolyKnight(String name) {
        this.life = 570;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.SWORD,Type.RADIANT);
        this.image = new ImageIcon("assets/monsters/holyKnight.png");
    }

    @Override
    public void attack(Monster enemy) {
        if (enemy.getTypes().contains(Type.DEMON)){
            this.activeSkill = skills.get(1);
        }
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "]  haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
        this.activeSkill = skills.get(0);
    }
    @Override
    public void onDamageReceive(Integer damage, Monster monster) {
        this.life = this.life - damage;
        if(this.life < 0) {
            this.life = 0;
        }
        System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida");
    }



}