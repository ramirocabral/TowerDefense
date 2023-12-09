package entregable.monstruos;
import entregable.ataques.Psychic.*;
import game.components.Monster;
import game.types.Type;

import java.util.Arrays;

public class Cadabra extends Monster {
    public Cadabra(String name) {
        this.life = 500;
        this.activeSkill = new Mindcrush();
        this.monsterName = name;
        this.types = Arrays.asList(Type.PSYCHIC, Type.DEMON);
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }
}
