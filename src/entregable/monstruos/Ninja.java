package entregable.monstruos;

import entregable.ataques.Water.KangarooKick;
import entregable.ataques.Water.TsunamiPunch;
import game.attacks.Attack;
import game.components.Monster;
import game.components.PathBox;
import game.random.RandomGenerator;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/*
 * Nombre: Ninja
 * Tipo: Agua (Principal)
 * Vida: 500
 * Ataques: TsunamiPunch, KangarooKick
 * Descripción: El Ninja es un monstruo que vivio en las sombras toda su vida, por lo que se especializa en el uso de ataques
 * sorpresivos. Su ataque principal es TsunamiPunch, el cual es un ataque que se basa en su pasado como ninja. Su segundo ataque
 * es KangarooKick, el cual es un ataque que se basa en su condicion como monstruo de agua. El Ninja tiene la habilidad de
 * esquivar ataques, por lo que tiene un 30% de chance de no recibir daño.
 * */

public class Ninja extends Monster {
    private List<Attack> skills = Arrays.asList(new TsunamiPunch() , new KangarooKick());
    public Ninja(String name) {
        this.life = 500;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.WATER);
        this.image = new ImageIcon("assets/monsters/ninja.png");
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }

    // tiene 30% de chance que no le peguen
    @Override
    public void onDamageReceive(Integer damage, Monster monster) {
        int probability = RandomGenerator.getInstance().calculateDamage(0,100);
        if (probability <= 30)
            damage = 0;
        this.life = this.life - damage;
        if(this.life < 0) {
            this.life = 0;
        }
        System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida");
    }

    //rotamos las habilidades
    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        super.move(oldPathBox, newPathBox);
        if(activeSkill instanceof TsunamiPunch) {
            this.activeSkill = skills.get(1);
        } else {
            this.activeSkill = skills.get(0);
        }
    }

}