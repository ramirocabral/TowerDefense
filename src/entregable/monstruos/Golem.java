package entregable.monstruos;

import entregable.ataques.Fire.Flamethrower;
import game.components.Monster;
import game.components.PathBox;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;


public class Golem extends Monster{
    //Es Fire
    //Le hace counter Demon y Agua

    private boolean movement_enabled;

    public Golem(String name) {
        this.life = 2000;
        this.activeSkill = new Flamethrower();
        this.monsterName = name;
        this.types = Arrays.asList(Type.FIRE);
        this.movement_enabled = false;
        this.image = new ImageIcon("assets/monsters/golem.png");
    }

        @Override
        public void attack(Monster enemy) {

            int damage = this.activeSkill.damage(enemy);
            System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
            enemy.onDamageReceive(damage, this);
        }

    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        if(movement_enabled){
            super.move(oldPathBox, newPathBox);
            movement_enabled = false;
        } else {
             movement_enabled = true;        }
    }
}