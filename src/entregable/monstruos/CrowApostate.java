package entregable.monstruos;

import entregable.ataques.Demon.VoidSlash;
import entregable.ataques.Electric.WattCharge;
import entregable.ataques.Sword.BladeSlash;
import game.attacks.Attack;
import game.components.Monster;
import game.types.Type;
import game.random.RandomGenerator;
import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class CrowApostate extends Monster {
    private List<Attack> skills = Arrays.asList(new BladeSlash());
    private int comboMeter = 1;

    public CrowApostate(String name) {
        this.life = 600;
        this.maxLife = this.life;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.VENOM, Type.SWORD);
        this.image = new ImageIcon("assets/monsters/crowApostate.png");
    }

    @Override
    public void attack(Monster enemy) {
        int MAX_PROBABILITY = 30;
        int currentProbability = 1, maxProbability = MAX_PROBABILITY;
        while (currentProbability < maxProbability) {
            currentProbability = RandomGenerator.getInstance().calculateDamage(0, 100);
            int damage = (this.activeSkill.damage(enemy)*comboMeter);
            if(this.life > 0 && this.life < this.maxLife)
                this.life = (int)(this.life + (damage*0.2));
            System.out.println("--     [" + this + "] ataca a [" + enemy + "] haciendole " + damage + " de daño : Combo " + comboMeter);
            enemy.onDamageReceive(damage, this);
            maxProbability -= 10;
            comboMeter++;
        }
        maxProbability = MAX_PROBABILITY;
        comboMeter = 1;
    }
}
