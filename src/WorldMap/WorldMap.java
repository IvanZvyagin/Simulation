package WorldMap;

import Entity.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WorldMap {
    public int length;
    public int width;
    public Map<Coordinate, Entity> mapWorld;

    public WorldMap(int lengthX, int widthY) {
        length = lengthX;
        width = widthY;
        mapWorld = new HashMap<>();
    }
    public void setEntity(Entity entity, Coordinate coordinate){
        entity.coordinate = coordinate;
        mapWorld.put(coordinate,entity);
    }

//    public void setupDefaultEntity(int x, int y){
//        Random random = new Random();
//        Coordinate coordinate;
//        do{
//            x = random.nextInt();
//            y = random.nextInt();
//            coordinate = new Coordinate(x,y);
//        }while
//    }


}