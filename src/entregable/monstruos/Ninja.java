package entregable.monstruos;

import entregable.ataques.Sword.BladeSlash;
import entregable.ataques.Water.KangarooKick;
import entregable.ataques.Water.TsunamiPunch;
import entregable.ataques.Water.Wave;
import game.attacks.Attack;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * Nombre: Ninja
 * Tipo: Agua (Principal), Espada (Secundario)
 * Vida: 500
 * Ataques: TsunamiPunch, KangarooKick, Wave, BladeSlash
 * Descripción: Maestro ninja con conexión única al elemento agua. Tiene 30% de chance de esquivar el ataque y
 * que no le hagan daño.
 * */

public class Ninja extends Monster {
    private List<Attack> skills = Arrays.asList(new TsunamiPunch() , new KangarooKick(), new Wave(), new BladeSlash());

    Iterator<Attack> iterator;

    public Ninja(String name) {
        this.life = 500;
        this.maxLife = this.life;
        this.monsterName = name;
        this.types = Arrays.asList(Type.WATER,Type.SWORD);
        this.image = new ImageIcon("assets/monsters/ninja.png");
        this.iterator = skills.iterator();
        this.activeSkill = this.iterator.next();
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] con ["+this.activeSkill.getClass()+"] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);

        //Cada vez que ataca cambia de habilidad
        if(!this.iterator.hasNext()) {
            this.iterator = skills.iterator();
        }
        this.activeSkill = this.iterator.next();
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