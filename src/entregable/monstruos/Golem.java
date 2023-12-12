package entregable.monstruos;
import game.attacks.Attack;
import game.attacks.ColdBreath;
import game.components.Monster;
import game.components.PathBox;
import game.types.Type;
import java.util.Arrays;
import entregable.ataques.Fire.*;



public class Golem extends Monster{
    //Es Fire
    //Le hace counter Demon y Agua

    private boolean movement_enabled;

    public Golem(String name) {
        this.life = 2000;
        this.activeSkill = new Flamethrower();
        this.monsterName = name;
        this.types = Arrays.asList(Type.FIRE);
        this.movement_enabled = false;
        }

        @Override
        public void attack(Monster enemy) {

            int damage = this.activeSkill.damage(enemy);
            System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
            enemy.onDamageReceive(damage, this);
        }

    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        if(movement_enabled){
            super.move(oldPathBox, newPathBox);
            movement_enabled = false;
        } else {
             movement_enabled = true;        }
    }
    @Override
    public void onDamageReceive(Integer damage, Monster monster) {
        this.life = this.life - damage;
        if(this.life < 0) {
            this.life = 0;
            this.activeSkill = new ColdBreath();
            attack(monster);
        }
        System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida");
    }
}