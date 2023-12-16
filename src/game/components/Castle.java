package game.components;

import javax.swing.*;
import java.util.Iterator;

public class Castle {

    private Integer castleLife = 3;
    private Path westPath;
    private Path eastPath;
    private JLabel[] lifeLabels;

    public Integer getCastleLife() {
        return castleLife;
    }

    public void nextRound(Long playerId, Iterator<Monster> monsterIterator) {
        if(!westPath.haveMonster(playerId)) {
            if(monsterIterator.hasNext()) {
                westPath.releaseMonster(playerId, monsterIterator.next());
            }
        } else {
            westPath.nextRound(playerId, this);
        }

        if(!eastPath.haveMonster(playerId)) {
            if(monsterIterator.hasNext()) {
                eastPath.releaseMonster(playerId, monsterIterator.next());
            }
        } else {
            eastPath.nextRound(playerId, this);
        }
        updateLifeLabel(castleLife);
        westPath.update();
        eastPath.update();
    }

    public void setCastleLife(Integer castleLife) {
        this.castleLife = castleLife;
    }

    public Path getWestPath() {
        return westPath;
    }

    public void setWestPath(Path westPath) {
        this.westPath = westPath;
    }

    public Path getEastPath() {
        return eastPath;
    }

    public void setEastPath(Path eastPath) {
        this.eastPath = eastPath;
    }

    public int getLife() {
        return this.castleLife;
    }

    public void setLife(int life) {this.castleLife = life;}

    public void setLifeLabels(JLabel[] lifeLabels) {
        this.lifeLabels = lifeLabels;
    }

    public void updateLifeLabel(int life) {
        this.castleLife = life;
        for (int i = 0; i < lifeLabels.length; i++) {
            if (i < life) {
                lifeLabels[i].setVisible(true);
            } else {
                lifeLabels[i].setVisible(false);
            }
        }
    }
}
