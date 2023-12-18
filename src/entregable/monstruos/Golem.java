package entregable.monstruos;

import entregable.ataques.Fire.Flamethrower;
import game.components.Monster;
import game.components.PathBox;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;

/*
 * Nombre: Golem
 * Tipo: Fuego (Principal)
 * Vida: 2200
 * Ataques: Flamethrower
 * Descripción: Criatura de fuego liberada de las ataduras de Blaze. Se mueve cada dos turnos.
 * */

public class Golem extends Monster{

    private boolean movement_enabled;

    public Golem(String name) {
        this.life = 2200;
        this.maxLife = this.life;
        this.activeSkill = new Flamethrower();
        this.monsterName = name;
        this.types = Arrays.asList(Type.FIRE);
        this.image = new ImageIcon("assets/monsters/golem.png");
        this.movement_enabled = false;
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
             movement_enabled = true;
        }
    }
}