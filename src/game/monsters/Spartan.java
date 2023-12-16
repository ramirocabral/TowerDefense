package game.monsters;

import game.attacks.Slice;
import game.components.Monster;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;

/*
 * Nombre: Spartan
 * Tipo: Sword (Principal)
 * Vida: 600
 * Ataques: Slice
 * Descripción: El Spartan es un monstruo que se especializa en el uso de la espada. Su ataque principal es Slice
 * el cual es un ataque que se basa en su condicion como guerrero.
 * */


public class Spartan extends Monster {

    public Spartan(String name) {
        this.life = 600;
        this.maxLife=600;
        this.activeSkill = new Slice();
        this.monsterName = name;
        this.types = Arrays.asList(Type.SWORD);
        this.image = new ImageIcon("assets/monsters/spartan.png");
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }
}
