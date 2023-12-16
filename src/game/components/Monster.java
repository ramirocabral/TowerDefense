package game.components;

import game.attacks.Attack;
import game.types.Type;

import javax.swing.*;
import java.util.List;

public abstract class Monster {

    protected Integer life;
    protected Attack activeSkill;
    private Player player;
    protected String monsterName;
    protected List<Type> types;
    private int minDamage;
    private int maxDamage;
    protected Icon image;


    public abstract void attack(Monster monster);

    public void onDamageReceive(Integer damage, Monster monster) {
        this.life = this.life - damage;
        if(this.life < 0) {
            this.life = 0;
        }
        System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida");
    }

    public void move(PathBox oldPathBox, PathBox newPathBox) {
        oldPathBox.setMonster(null);
        newPathBox.setMonster(this);
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(int life){
        this.life = life;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Type> getTypes() {
        return types;
    }

    @Override
    public String toString() {
        return monsterName;
    }

    public int getAverageDamage(){
        return ((this.activeSkill.getMaxDamage() + this.activeSkill.getMinDamage())/2);
    }

    public Icon getImage(){
        return this.image;
    }

}