package Creature;

import Entity.*;
import WorldMap.Coordinate;
import WorldMap.WorldMap;

public abstract class Creature extends Entity {
    private int hp;
    private int speed;

    public Creature(int hp, int speed) {
        this.hp = hp;
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void makeMove(WorldMap map){

    }
    public boolean isDead(){
        return this.hp <= 0;
    }
}