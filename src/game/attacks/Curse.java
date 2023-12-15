package game.attacks;

import game.components.Monster;

public class Curse implements Demon {

    @Override
    public int damage(Monster monster) {
        return 400;
    }
    @Override
    public int getMinDamage(){
        return 400;
    }
    @Override
    public int getMaxDamage(){
        return 400;
    }
}
