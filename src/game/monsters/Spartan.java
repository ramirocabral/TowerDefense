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
 * Descripción: Guerrero imponente y leal al bien.
 * */


public class Spartan extends Monster {
    public Spartan(String name) {
        this.life = 600;
        this.maxLife = this.life;
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
