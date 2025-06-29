package Creature;

import Entity.Entity;
import WorldMap.Coordinate;
import Entity.EntityType;

public class Creature extends Entity {
    public final int health;
    public final int speed;

    public Creature(EntityType type, Coordinate coordinate, int health, int speed) {
        super(type, coordinate);
        this.health = health;
        this.speed = speed;
    }
}