package Creature;

import Entity.Grass;
import TurnActions.FindObject;
import WorldMap.Coordinate;
import WorldMap.WorldMap;

import java.util.List;

public class Herbivore extends Creature {
    public Herbivore(int hp, int speed) {
        super(hp, speed);
    }
    public void makeMove(WorldMap map){
        List<Coordinate>foundPath = FindObject.find(map,this, Grass.class);
        if(!foundPath.isEmpty()){
            map.removeEntity(map.findCoordinate(this));
            if(foundPath.size() <= getSpeed()){
                map.setEntity(this, foundPath.get(foundPath.size()-1));
            }else{
                map.setEntity(this,foundPath.get(getSpeed() -1 ));
            }
        }
    }
}