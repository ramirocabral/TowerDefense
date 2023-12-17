package entregable.monstruos;

import entregable.ataques.Electric.Discharge;
import entregable.ataques.Electric.Electric;
import entregable.ataques.Electric.Thunderstrike;
import entregable.ataques.Electric.WattCharge;
import game.attacks.Attack;
import game.components.Monster;
import game.components.PathBox;
import game.random.RandomGenerator;
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
    private List<Attack> skills = Arrays.asList(new Discharge() , new Thunderstrike());
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
        if(this.life < 200 && this.life > 0) {
            heal();
        }
        damage = this.activeSkill.damage(enemy);
        System.out.println("--     [" + this + "] ataca a [" + enemy + "] con "+this.activeSkill.getClass()+"haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
        if (this.activeSkill == skills.get(0)) {
            this.activeSkill = skills.get(1);
        }
        else{
            this.activeSkill = skills.get(0);
        }
    }

    public void heal(){
        int increase =  RandomGenerator.getInstance().calculateDamage(50,100);
        this.life = this.life + increase;
        System.out.println("[ElectroBoom] se cura " + increase + " de vida");
    }
}
