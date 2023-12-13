package entregable.monstruos;
import entregable.ataques.Electric.*;
import game.attacks.ColdBreath;
import game.components.Monster;
import game.attacks.Attack;
import game.components.PathBox;
import game.types.Type;
import java.util.Arrays;
import java.util.List;


public class ElectroBOOM extends Monster{
    private List<Attack> skills = Arrays.asList(new Discharge() , new Thunderstrike());

    public ElectroBOOM(String name){
        this.life = 500;
        this.activeSkill = skills.get(0);
        this.monsterName = name;
        this.types = Arrays.asList(Type.ELECTRIC);
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
        this.activeSkill = skills.get(0);
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
