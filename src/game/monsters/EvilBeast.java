package game.monsters;

import game.attacks.Curse;
import game.components.Monster;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;

public class EvilBeast extends Monster {

    public EvilBeast(String name) {
        this.life = 700;
        this.monsterName = name;
        this.activeSkill = new Curse();
        this.types = Arrays.asList(Type.DEMON, Type.BEAST, Type.FIRE);
        this.image = new ImageIcon("assets/monsters/evilBeast.png");
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }
}
