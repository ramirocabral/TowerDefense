package entregable.monstruos;

import entregable.ataques.Radiant.HolyLight;
import game.attacks.Attack;
import game.components.Monster;
import game.components.PathBox;
import game.random.RandomGenerator;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/*
 * Nombre: Cleric
 * Tipo: Radiante (Principal), Demonio
 * Vida: 400
 * Ataques: HolyLight
 * Descripción: El Cleric es un monstruo que se especializa en el poder celestial. Su ataque principal es HolyLight, el cual
 * es un ataque que se basa en su pasado como sacerdote. El Cleric tiene la habilidad de invocar a un Archangel con una probabilidad
 * del 20% cuando muere.
 * */

public class Cleric extends Monster {
    private List<Attack> skills = Arrays.asList(new HolyLight());
    private PathBox actualPathBox;

    public Cleric(String name) {
        this.life = 400;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.RADIANT);
        this.image = new ImageIcon("assets/monsters/cleric.png");
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "]  haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }
    @Override
    public void onDamageReceive(Integer damage, Monster monster) {
        this.life = this.life - damage;
        if(this.life < 0) {
            this.life = 0;
            int probability = RandomGenerator.getInstance().calculateDamage(0,100);
            if(probability <= 100){
                Archangel archangel = new Archangel("archangel");
                archangel.setPlayer(this.getPlayer());
                actualPathBox.setMonster(archangel);
            }
        }
        System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida");
    }

    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        actualPathBox = oldPathBox;
        super.move(oldPathBox, newPathBox);
    }

}
