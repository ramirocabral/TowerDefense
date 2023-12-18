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
 * Tipo: Radiante (Principal), Fuego (Secundario), Sword (Secundario)
 * Vida: 600
 * Ataques: CelestialSlash, FireNova
 * Descripción: Mensajero celestial enviado para restaurar la paz. Su ataque principal es CelestialSlash, pero si
 * se encuentra con un demonio, su ataque cambia a FireNova, el cual hace mucho más daño.
 * */
public class Archangel extends Monster {
    private List<Attack> skills = Arrays.asList(new CelestialSlash(), new FireNova());
    private boolean oneshot;
    public Archangel(String name) {
        this.life = 700;
        this.maxLife = this.life;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.RADIANT, Type.FIRE, Type.SWORD);
        this.image = new ImageIcon("assets/monsters/archangel.png");
        this.oneshot = true;
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
