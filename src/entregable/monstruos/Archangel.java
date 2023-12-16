package entregable.monstruos;

import entregable.ataques.Fire.FireNova;
import entregable.ataques.Radiant.CelestialSlash;
import game.attacks.Attack;
import game.components.Monster;
import game.components.PathBox;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/*
 * Nombre: Archangel
 * Tipo: Radiante (Principal), Fuego
 * Vida: 600
 * Ataques: CelestialSlash, FireNova
 * Descripción: El Archangel es un monstruo que se especializa en el uso de la espada. Su ataque principal es CelestialSlash,
 * el cual es un ataque que se basa en la fuerza del Archangel. Su segundo ataque es FireNova, el cual es un ataque que se basa
 * en la inteligencia del Archangel. El Archangel tiene la habilidad de hacer un ataque que mata a cualquier demonio de un solo
 * golpe. El Archangel es un monstruo que es invocado por Cleric con una probabilidad del 20% cuando este muere.
 * */
public class Archangel extends Monster {
    private List<Attack> skills = Arrays.asList(new CelestialSlash(), new FireNova());
    private boolean oneshot = true;
    public Archangel(String name) {
        this.life = 600;
        this.maxLife = 600;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.RADIANT, Type.FIRE, Type.SWORD);
        this.image = new ImageIcon("assets/monsters/Archangel.png");
    }

    @Override
    public void attack(Monster enemy) {
        if (enemy.getTypes().contains(Type.DEMON) && oneshot){
            this.activeSkill = skills.get(1);
            oneshot = false;
        }
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     [" + this + "] ataca a [" + enemy + "]  haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
        this.activeSkill = skills.get(0);
    }
    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        oldPathBox.setMonster(null);
        newPathBox.setMonster(this);
    }
}
