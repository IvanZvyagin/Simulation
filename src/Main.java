package WorldMap;
import Entity.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation(10,10);
        simulation.startSimulation(simulation.getMap());
//        WorldMap worldMap = new WorldMap(10,10);
//        Entity grass = new Grass();
//        Entity rock = new Rock();
//        Coordinate coordinateRock = new Coordinate(6,4);
//        Coordinate coordinateGrass = new Coordinate(5,5);
//        worldMap.setEntity(grass,coordinateGrass);
//        worldMap.setEntity(rock,coordinateRock);
//        try {
//            MapRenderer.render(worldMap);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//

    }
}
