package entregable.monstruos;


import entregable.ataques.Fire.FireBall;
import entregable.ataques.Fire.Flamethrower;
import game.attacks.Attack;
import game.components.Monster;
import game.components.RumbleGame;
import game.types.Type;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;




public class Blaze extends Monster {
    private List<Attack> skills = Arrays.asList(new FireBall(), new Flamethrower());

    public Blaze(String name) {
        this.life = 350;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.FIRE);
        this.image = new ImageIcon("assets/monsters/Blaze.png");
    }
    //RumbleGame.getInstance().getRound();
    @Override
    //A medida que aumentan las rondas pega mas
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy) * (int) ( RumbleGame.getInstance().getRound() * 1.05);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }
}
