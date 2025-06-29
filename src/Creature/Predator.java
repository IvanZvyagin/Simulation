package Creature;

import Entity.EntityType;
import WorldMap.Coordinate;

public class Predator extends Creature{
    public int attackPower;

    public Predator(EntityType type, Coordinate coordinate, int hp, int speed, int attackPower) {
        super(type, coordinate, hp, speed);
        this.attackPower = attackPower;
    }
}