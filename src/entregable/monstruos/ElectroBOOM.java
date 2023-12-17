package entregable.monstruos;

import entregable.ataques.Electric.Discharge;
import entregable.ataques.Electric.Electric;
import entregable.ataques.Electric.Thunderstrike;
import entregable.ataques.Electric.WattCharge;
import game.attacks.Attack;
import game.components.Monster;
import game.components.PathBox;
import game.types.Type;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * Nombre: ElectroBOOM
 * Tipo: Electrico (Principal)
 * Vida: 500
 * Ataques: Discharge, Thunderstrike
 * Descripción: Youtuber convertido en maga elemental de electricidad. Si su vida es menor a 200, se cura.
 * */


public class ElectroBOOM extends Monster{
    private List<Attack> skills = Arrays.asList(new Discharge() , new Thunderstrike(), new WattCharge());
    //iterator
    private Iterator<Attack> skillsIterator = skills.iterator();

    public ElectroBOOM(String name){
        this.life = 500;
        this.maxLife = this.life;
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
        if (!skillsIterator.hasNext()) {
            skillsIterator = skills.iterator();  // vuelve al principio
        }

        this.activeSkill = skillsIterator.next();

    }
}
