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
 * Vida: 2000
 * Ataques: Flamethrower
 * Descripción: El Golem es un monstruo que se caracteriza por su gran resistencia. Su ataque principal es Flamethrower,
 * el cual es un ataque que se basa en su condicion como monstruo de fuego. El Golem, debido a su tamaño, solo puede
 * moverse cada dos turnos.
 * */

public class Golem extends Monster{

    private boolean movement_enabled;

    public Golem(String name) {
        this.life = 2200;
        this.maxLife=2200;
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