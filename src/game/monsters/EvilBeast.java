package game.monsters;

import game.attacks.Curse;
import game.components.Monster;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
/*
 * Nombre: EvilBeast
 * Tipo: Demon (Principal
 * Vida: 666
 * Ataques: Curse
 * Descripción: El EvilBeast es un monstruo que se especializa en el uso de la maldad. Su ataque principal es Curse
 * el cual es un ataque que se basa en su condicion como monstruo demoniaco.
 * */


public class EvilBeast extends Monster {

    public EvilBeast(String name) {
        this.life = 666;
        this.maxLife= 666;
        this.monsterName = name;
        this.activeSkill = new Curse();
        this.types = Arrays.asList(Type.BEAST, Type.DEMON, Type.FIRE);
        this.image = new ImageIcon("assets/monsters/evilBeast.png");
    }



    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }
}
