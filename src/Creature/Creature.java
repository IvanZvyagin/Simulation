package Creature;

import Entity.*;
import WorldMap.Coordinate;

public abstract class Creature extends Entity {
    private int hp;
    private int speed;

    public Creature(EntityType type, Coordinate coordinate, int hp, int speed) {
        super(type, coordinate);
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
}