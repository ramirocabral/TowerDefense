package entregable.monstruos;

import entregable.ataques.Water.Wave;
import game.components.Monster;
import game.components.Player;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;

/*
 * Nombre: Siren
 * Tipo: Agua (Principal), Radiante
 * Vida: 1200
 * Ataques: Wave
 * La siren es curandera
 * Descripción: La Siren es un monstruo que se caracteriza por su compañerismo. Su ataque principal es Wave,
 * el cual es un ataque que se basa en su condicion como monstruo de agua. La Siren tiene la habilidad de curar a su equipo
 * cada dos turnos.
 * */

public class Siren extends Monster {
    private boolean heal;

    public Siren(String name) {
        this.life = 1200;
        this.maxLife = 1200;
        this.activeSkill = new Wave();
        this.monsterName = name;
        this.types = Arrays.asList(Type.WATER, Type.RADIANT);
        this.image = new ImageIcon("assets/monsters/nami.png");
        this.heal = false;
    }

    @Override
    public void attack(Monster enemy) {
        if (heal) {
           heal();
        }
        else {
            int damage = this.activeSkill.damage(enemy);
            System.out.println("--     [" + this + "] ataca a [" + enemy + "]  haciendole " + damage + " de daño");
            enemy.onDamageReceive(damage, this);
        }
        heal = !heal;
    }

    public void heal() {
        this.setLife(this.life + 200);
        Player player = this.getPlayer();
        Monster m;
        if ((player.getCastle().getEastPath().getMonster(player.getId()) != null) && player.getCastle().getEastPath().getMonster(player.getId()).equals(this)) {
            m = player.getCastle().getWestPath().getMonster(player.getId());
        }
        else {
            m = player.getCastle().getEastPath().getMonster(player.getId());
        }
        if (m != null) {
            m.setLife(m.getLife() + 200);
            System.out.println(this.toString() + " cura a " + m.toString() + " 200 de vida.");
        }
    }
}
