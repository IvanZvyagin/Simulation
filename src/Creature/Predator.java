package Creature;

import Entity.EntityType;
import WorldMap.Coordinate;
import WorldMap.WorldMap;

public class Predator extends Creature{
    private int attackPower;

    public Predator(int hp, int speed, int attackPower) {
        super(hp, speed);
        this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void makeMove(WorldMap map){

    }
}