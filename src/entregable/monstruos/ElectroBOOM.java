package entregable.monstruos;

import entregable.ataques.Electric.Discharge;
import entregable.ataques.Electric.Thunderstrike;
import entregable.ataques.Electric.WattCharge;
import game.attacks.Attack;
import game.components.Monster;
import game.components.PathBox;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/*
 * Nombre: ElectroBOOM
 * Tipo: Electrico (Principal)
 * Vida: 500
 * Ataques: Discharge, Thunderstrike
 * Descripción: El ElectroBOOM es un monstruo que se especializa en el uso de la fisica, basada en su pasado como Youtuber.
 * Su ataque principal es Discharge, el cual es un ataque que se basa en su pasado como fisico.
 * */


public class ElectroBOOM extends Monster{
    private List<Attack> skills = Arrays.asList(new Discharge() , new Thunderstrike(), new WattCharge());

    public ElectroBOOM(String name){
        this.life = 500;
        this.maxLife=500;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.ELECTRIC);
        this.image = new ImageIcon("assets/monsters/electroBOOM.png");
    }

    @Override
    public void attack(Monster enemy) {
        int damage;
        if(this.life < 200 && this.life > 0){
            this.activeSkill = skills.get(2);
            damage = this.activeSkill.damage(this);
            System.out.println("--     ["+ this +"] recarga " + damage + " de vida");
            this.life = this.life + damage;
            this.activeSkill = skills.get(0);
        }else {
            damage = this.activeSkill.damage(enemy);
            System.out.println("--     [" + this + "] ataca a [" + enemy + "] haciendole " + damage + " de daño");
            enemy.onDamageReceive(damage, this);
        }
    }

    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        super.move(oldPathBox, newPathBox);
        if(activeSkill instanceof Discharge) {
            this.activeSkill = skills.get(1);
        } else {
            this.activeSkill = skills.get(0);
        }
    }
}
