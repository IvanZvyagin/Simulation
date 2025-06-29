package Creature;

import Entity.EntityType;
import WorldMap.Coordinate;

public class Herbivore extends Creature{
    public Herbivore(EntityType type, Coordinate coordinate, int hp, int speed) {
        super(type, coordinate, hp, speed);
    }
}