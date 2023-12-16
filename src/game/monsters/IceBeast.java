package game.monsters;

import game.attacks.Cold;
import game.attacks.ColdBreath;
import game.attacks.IceSpike;
import game.components.Monster;
import game.components.PathBox;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
/*
 * Nombre: IceBeast
 * Tipo: Cold (Principal)
 * Vida: 900
 * Ataques: ColdBreath, IceSpike
 * Descripción: El IceBeast es un monstruo que se especializa en el uso de la magia. Su ataque principal es ColdBreath
 * el cual es un ataque que se basa en su condicion como monstruo de hielo.
 * */


public class IceBeast extends Monster {

    private List<Cold> skills = Arrays.asList(new ColdBreath(), new IceSpike());

    public IceBeast(String name) {
        this.life = 900;
        this.maxLife= 900;
        this.monsterName = name;
        this.activeSkill = skills.get(0);
        this.types = Arrays.asList(Type.COLD, Type.BEAST);
        this.image = new ImageIcon("assets/monsters/iceBeast.png");
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }

    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        super.move(oldPathBox, newPathBox);
        if(activeSkill instanceof ColdBreath) {
            this.activeSkill = skills.get(1);
        } else {
            this.activeSkill = skills.get(0);
        }
    }
}
