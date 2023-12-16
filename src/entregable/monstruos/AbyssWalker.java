package entregable.monstruos;

import entregable.ataques.Demon.VoidSlash;
import entregable.ataques.Venom.PoisonCover;
import game.attacks.Attack;
import game.components.Monster;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

//Realizar un comentario de varias lineas sobre el mounstro, sus tipos y ataques

/*
* Nombre: AbyssWalker
* Tipo: Demonio (Principal), Espada
* Vida: 800
* Ataques: VoidSlash, PoisonCover
* Descripción: El AbyssWalker es un demonio que se especializa en el uso de la espada. Su ataque principal es VoidSlash, el cual
* es un ataque que se basa en la fuerza del AbyssWalker. Su segundo ataque es PoisonCover, el cual es un ataque que se basa en la
* inteligencia del AbyssWalker. El AbyssWalker tiene la habilidad de curarse a si mismo cuando su vida es menor a 200.
* El AbyssWalker tiene un medidor de daño, el cual se llena cada vez que el AbyssWalker ataca. Cuando el medidor de daño se llena,
* el AbyssWalker potencia su ataque.
* */

public class AbyssWalker extends Monster{

    private List<Attack> skills = Arrays.asList(new VoidSlash(), new PoisonCover());
    private final int DAMAGEMAX = 400;
    private int  DamageMeter = 0;
    public AbyssWalker(String name) {
        this.life = 800;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.DEMON, Type.SWORD);
        this.image = new ImageIcon("assets/monsters/AbyssWalker.png");
    }

    @Override
    public void attack(Monster enemy) {
        int damage;
        if(this.life < 200){
            damage = this.activeSkill.damage(this);
            System.out.println("--     ["+ this +"] se cura " + damage + " de vida");
            this.life = this.life + damage;
        }else {
            damage = this.activeSkill.damage(enemy);
            DamageMeter += damage;
            if (DamageMeter >= DAMAGEMAX) {
                damage = damage + DamageMeter;
                DamageMeter = 0;
                System.out.println("El medidor de daño se lleno, el ataque de [" + this + "] se potencia");
            }
            System.out.println("--     [" + this + "] ataca a [" + enemy + "] haciendole " + damage + " de daño");
            enemy.onDamageReceive(damage, this);
        }
    }
}
