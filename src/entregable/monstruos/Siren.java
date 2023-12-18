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
 * Vida: 500
 * Ataques: Wave
 * Descripción: Criatura mítica con canto hipnotizador. Cada turno por medio cura a un aliado 150 de vida como maximo,
 * si el aliado tiene la vida llena lo cura al maximo pero le saca 50 de vida del maximo que puede tener.
 * */

public class Siren extends Monster {
    private boolean heal;

    public Siren(String name) {
        this.life = 500;
        this.maxLife = this.life;
        this.activeSkill = new Wave();
        this.monsterName = name;
        this.types = Arrays.asList(Type.WATER, Type.RADIANT);
        this.image = new ImageIcon("assets/monsters/siren.png");
        this.heal = false;
    }

    @Override
    public void attack(Monster enemy) {
        if (heal) { heal(); }
        else {
            int damage = this.activeSkill.damage(enemy);
            System.out.println("--     [" + this + "] ataca a [" + enemy + "]  haciendole " + damage + " de daño");
            enemy.onDamageReceive(damage, this);
        }
        heal = !heal;
    }

    private void heal() {
        if(this.life + 150 > this.maxLife){
            this.life = this.maxLife;
        }
        else{
            this.setLife(this.life + 150);
        }
        Player player = this.getPlayer();
        //obtenemos el monstruo aliado presente en la otra linea
        Monster m;
        if ((player.getCastle().getEastPath().contains(this))) {
            m = player.getCastle().getWestPath().getMonster(player.getId());
        }
        else {
            m = player.getCastle().getEastPath().getMonster(player.getId());
        }
        if (m != null) {
            if(m.getLife() + 150 > m.getMaxLife()) {
                if(m.getMaxLife() > 50){
                    m.setMaxLife(m.getMaxLife() - 50);
                }
                m.setLife(m.getMaxLife());
                System.out.println(this.toString() + " cura a " + m.toString() + " hasta su nueva vida maxima: " + m.getMaxLife());
                return ;
        }
        m.setLife(m.getLife() + 150);
        System.out.println(this.toString() + " cura a " + m.toString() + " 150 de vida.");
        }
    }
}