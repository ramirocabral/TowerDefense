package game.monsters;

import game.attacks.Curse;
import game.components.Monster;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
/*
 * Nombre: EvilBeast
 * Tipo: Beast (Principal), Demon, (Secundario), Fire (Secundario)
 * Vida: 666
 * Ataques: Curse
 * Descripción: Encarnación de la oscuridad.
 * */


public class EvilBeast extends Monster {

    public EvilBeast(String name) {
        this.life = 666;
        this.maxLife = this.life;
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
