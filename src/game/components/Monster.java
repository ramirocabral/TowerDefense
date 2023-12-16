package game.components;

import game.attacks.Attack;
import game.types.Type;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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
//    private JProgressBar healthBar;

    public abstract void attack(Monster monster);

    public void onDamageReceive(Integer damage, Monster monster) {
        this.life = this.life - damage;
        if(this.life < 0) {
            this.life = 0;
        }
//        updateHealthBar(this.life);
        System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida");
    }

    public void move(PathBox oldPathBox, PathBox newPathBox) {
        oldPathBox.setMonster(null);
        newPathBox.setMonster(this);
    }

//    public void initHealthBar() {
//        healthBar = new JProgressBar(0, this.life);
//        healthBar.setValue(this.life);
//        healthBar.setPreferredSize(new Dimension(90, 13));
//        healthBar.setMaximumSize(new Dimension(90, 13));
//        healthBar.setAlignmentX(SwingConstants.RIGHT);
//        if (this.player.getId() == 1) {
//            healthBar.setForeground(Color.BLUE);
//        } else {
//            healthBar.setForeground(Color.RED);
//        }
//    }

//    public void updateHealthBar(int damage) {
//        healthBar.setValue(this.life);
//    }
//
//    public JProgressBar getHealthBar() {
//        return healthBar;
//    }

    public Integer getLife() {
        return life;
    }

    public Integer getMaxLife() {
        return maxLife;
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

}