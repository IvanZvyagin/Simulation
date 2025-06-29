package Creature;

import Entity.Entity;

public class Creature extends Entity {
    private int hp;
    private int speed;
    private int attackPower;

    public Creature(String sprite, int hp, int speed, int attackPower) {
        super(sprite);
        this.hp = hp;
        this.speed = speed;
        this.attackPower = attackPower;
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

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}