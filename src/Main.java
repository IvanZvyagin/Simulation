package WorldMap;
import Entity.*;
import InitActions.EntityFabric;


public class Main {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap(10,10);
        Entity grass = new Grass();
        Entity rock = new Rock();
        Coordinate coordinateRock = new Coordinate(6,4);
        Coordinate coordinateGrass = new Coordinate(5,5);
        worldMap.setEntity(grass,coordinateGrass);
        worldMap.setEntity(rock,coordinateRock);
        try {
            MapRenderer.render(worldMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
