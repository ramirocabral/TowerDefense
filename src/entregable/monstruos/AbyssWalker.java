package entregable.monstruos;

import entregable.ataques.Demon.VoidSlash;
import entregable.ataques.Electric.WattCharge;
import game.attacks.Attack;
import game.components.Monster;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;


/*
* Nombre: AbyssWalker
* Tipo: Demonio (Principal), Espada (Secundario)
* Vida: 800
* Ataques: VoidSlash, PoisonCover
* Descripción: Valiente guerrero corrompido por su sacrificio contra EvilBeast. A medida que hace daño, va
* cargando su medidor de daño, el cual al llenarse, potencia su ataque.
* */

public class AbyssWalker extends Monster{

    private List<Attack> skills = Arrays.asList(new VoidSlash());
    private final int DAMAGEMAX = 400;
    private int DamageMeter;
    public AbyssWalker(String name) {
        this.life = 800;
        this.maxLife = this.life;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.DEMON, Type.SWORD);
        this.image = new ImageIcon("assets/monsters/abyssWalker.png");
        this.DamageMeter = 0;
    }

    @Override
    public void attack(Monster enemy) {

        int damage = this.activeSkill.damage(enemy);
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

