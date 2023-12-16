package game.components;

import javax.swing.*;
import java.awt.*;

public class PathBox {
    private Monster monster;
    private PathBox southBox;
    private PathBox northBox;
    private String name;
    private JLabel buttonUI;
    private JProgressBar healthBar;

    public PathBox(JLabel buttonUI, JProgressBar healthBar, String name) {
        this.buttonUI = buttonUI;
        this.healthBar = healthBar;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Monster getMonster() {
        return monster;
    }

    //TODO: cambiar
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public JLabel getButtonUI() {
        return buttonUI;
    }

    public void setButtonUI(JLabel buttonUI) {
        this.buttonUI = buttonUI;
    }
    public void setHealthBar(JProgressBar healthBar) {
        this.healthBar = healthBar;
    }

    public JProgressBar getHealthBar() {
        return healthBar;
    }

    public PathBox getSouthBox() {
        return southBox;
    }

    public void setSouthBox(PathBox southBox) {
        this.southBox = southBox;
    }

    public PathBox getNorthBox() {
        return northBox;
    }

    public void setNorthBox(PathBox northBox) {
        this.northBox = northBox;
    }

    public void update() {
        if(this.monster != null) {
            buttonUI.setIcon(monster.getImage());
            buttonUI.setPreferredSize(new Dimension(80, 85));
            buttonUI.setVisible(true);
            this.healthBar.setForeground(Color.BLACK);
            JLabel lifeString = new JLabel(String.valueOf(monster.getLife()));
            this.healthBar.setString(lifeString.getText());
//            this.healthBar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            this.healthBar.setMaximum(monster.getMaxLife());
            this.healthBar.setValue(monster.getLife());
            //this.healthBar.setString(String.valueOf(monster.getLife()));
            this.healthBar.setStringPainted(true);
            if (monster.getPlayer().getId().equals(1L)) {
                this.healthBar.setForeground(new Color(123, 179, 252));
            } else {
                this.healthBar.setForeground(new Color(231, 123, 123));
            }

            this.healthBar.setVisible(true);
        } else {
            buttonUI.setVisible(false);
            this.healthBar.setVisible(false);
        }
    }
}
