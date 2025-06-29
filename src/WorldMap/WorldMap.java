package WorldMap;

import Entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {
    private int length;
    private int width;
    private Map<Coordinate, Entity> mapWorld;

    public WorldMap(int lengthX, int widthY) {
        length = lengthX;
        width = widthY;
        mapWorld = new HashMap<>();
    }
    public void setEntity(Entity entity, Coordinate coordinate){
        entity.coordinate = coordinate;
        mapWorld.put(coordinate,entity);
    }
    public void setupDefoltEntity(){

    }


}