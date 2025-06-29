package Creature;

import Entity.EntityType;
import WorldMap.Coordinate;

public class Predator extends Creature {
    public final int attackPower;

    public Predator(EntityType type, Coordinate coordinate, int health, int speed, int attackPower) {
        super(type, coordinate, health, speed);
        this.attackPower = attackPower;
    }
}