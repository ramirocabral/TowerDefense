package entregable.monstruos;


import entregable.ataques.Fire.FireBall;
import entregable.ataques.Fire.Flamethrower;
import game.attacks.Attack;
import game.components.Monster;
import game.components.RumbleGame;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;


/*
 * Nombre: Blaze
 * Tipo: Fuego (Principal)
 * Vida: 350
 * Ataques: FireBall, Flamethrower
 * Descripción: El Blaze es un monstruo que se especializa en el uso de la magia. Su ataque principal es FireBall, el cual
 * es un ataque que se basa en su pasado como mago. Su segundo ataque es Flamethrower, el cual es un ataque que se basa en
 * su condicion como monstruo de fuego. El Blaze tiene la habilidad de potenciar su ataque a medida que aumentan las rondas.
 * */

public class Blaze extends Monster {
    private List<Attack> skills = Arrays.asList(new FireBall(), new Flamethrower());

    public Blaze(String name) {
        this.life = 350;
        this.maxLife=this.life;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.FIRE);
        this.image = new ImageIcon("assets/monsters/Blaze.png");
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy) * (int) ( RumbleGame.getInstance().getRound() * 1.05);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }
}
