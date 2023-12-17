package entregable.monstruos;

import entregable.ataques.Radiant.HolyLight;
import game.attacks.Attack;
import game.attacks.Slice;
import game.components.Monster;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/*
 * Nombre: HolyKnight
 * Tipo: Radiante (Principal), Espada (Secundario)
 * Vida: 570
 * Ataques: Slice, HolyLight
 * Descripción: Caballero valiente con espada sagrada. Cuando este muere, revive con 1 de vida (solo la primera vez).
 * */

public class HolyKnight extends Monster {
    private List<Attack> skills = Arrays.asList(new Slice(), new HolyLight());
    private boolean revive;
    public HolyKnight(String name) {
        this.life = 570;
        this.maxLife = this.life;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.RADIANT, Type.SWORD);
        this.image = new ImageIcon("assets/monsters/holyKnight.png");
        this.revive = true;
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
            if(revive) {
                this.life = 1;
                revive = false;
                System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida debido a que revive");
                return;
            }
            this.life = 0;
        }
        System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida");
    }

}