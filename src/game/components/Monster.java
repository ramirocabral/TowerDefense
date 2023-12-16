package game.components;

import game.attacks.Attack;
import game.types.Type;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public abstract class Monster {

    protected Integer life;
    protected Integer maxLife;
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

    public Integer getMaxLife() {
        return this.maxLife;
    }

    public void setLife(int life){
        this.life = life;
    }

    public void setMaxLife(int maxLife){
        this.maxLife = maxLife;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return minDamage == monster.minDamage && maxDamage == monster.maxDamage && Objects.equals(life, monster.life) && Objects.equals(maxLife, monster.maxLife) && Objects.equals(activeSkill, monster.activeSkill) && Objects.equals(player, monster.player) && Objects.equals(monsterName, monster.monsterName) && Objects.equals(types, monster.types) && Objects.equals(image, monster.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(life, maxLife, activeSkill, player, monsterName, types, minDamage, maxDamage, image);
    }
}