package Entity.creature;

import Entity.Entity;

public abstract class Creature extends Entity {
    private int speed;
    private int hp;

    protected Creature(int x, int y) {
        super(x, y);
    }
    private void makeMove(){

    }
}

