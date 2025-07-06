package Creature;

import TurnActions.FindObject;
import WorldMap.Coordinate;
import WorldMap.WorldMap;

import java.util.List;

public class Predator extends Creature {
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

    public void makeMove(WorldMap map) {
        List<Coordinate> foundPath = FindObject.find(map, this, Herbivore.class);
        Coordinate originalPosition = map.findCoordinate(this);
        if (!foundPath.isEmpty()) {
            map.removeEntity(originalPosition);
            if (foundPath.size() == 1) {
                Herbivore foundHerbivore = (Herbivore) map.getEntity(foundPath.get(0));
                if (foundHerbivore.getHp() - attackPower <= 0) {
                    foundHerbivore.setHp(foundHerbivore.getHp() - attackPower);
                    map.setEntity(this, foundPath.get(0));
                } else {
                    map.setEntity(this, originalPosition);
                    foundHerbivore.setHp(foundHerbivore.getHp() - attackPower);
                }
            } else if (foundPath.size() <= getSpeed()) {
                map.setEntity(this, foundPath.get(foundPath.size() - 2));
            } else {
                map.setEntity(this, foundPath.get(foundPath.size() - 1));
            }
        }

    }
}