package entregable.monstruos;

import entregable.ataques.Psychic.Mindcrush;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;

/*
 * Nombre: Cadabra
 * Tipo: Psiquico (Principal), Demonio (Secundario)
 * Vida: 500
 * Ataques: Mindcrush
 * Descripción: Hechicero solitario y poderoso. Tiene la habilidad de devolver el ataque a su enemigo con una
 * probabilidad del 30%.
 * */

public class Cadabra extends Monster {
    public Cadabra(String name) {
        this.life = 500;
        this.maxLife = this.life;
        this.activeSkill = new Mindcrush();
        this.monsterName = name;
        this.types = Arrays.asList(Type.PSYCHIC, Type.DEMON);
        this.image = new ImageIcon("assets/monsters/cadabra.png");
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }
    @Override
    public void onDamageReceive(Integer damage, Monster monster) {
        if (RandomGenerator.getInstance().calculateDamage(0, 100) < 30) {
            System.out.println(this + " Le devuelve el ataque a " + monster);
            monster.onDamageReceive(damage, this);
            return;
        }else{
            this.life = this.life - damage;
            if(this.life < 0){
                this.life = 0;
            }
        }
        System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida");

    }
}
