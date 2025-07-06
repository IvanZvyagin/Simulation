package WorldMap;

import Entity.Entity;

import java.util.*;

public class WorldMap {
    private int length;
    private int width;
    private Map<Coordinate, Entity> entityMap;

    public WorldMap(int lengthX, int widthY) {
        length = lengthX;
        width = widthY;
        entityMap = new HashMap<>();
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setEntity(Entity entity, Coordinate coordinate) {
        entityMap.put(coordinate, entity);
    }

    public void removeEntity(Coordinate coordinate) {
        entityMap.remove(coordinate);
    }

    public Entity getEntity(Coordinate coordinate) {
        return entityMap.get(coordinate);
    }

    public boolean isCoordinateExist(Coordinate coordinate) {
        return entityMap.containsKey(coordinate);
    }
    public Collection<Entity> getAllEntities(){
        return Collections.unmodifiableCollection(entityMap.values());
    }

    public void setupEntity(Entity entity) {
        Random random = new Random();
        Coordinate coordinate;
        do {
            int x = random.nextInt(length);
            int y = random.nextInt(width);
            coordinate = new Coordinate(x, y);
        } while (isCoordinateExist(coordinate));
        entityMap.put(coordinate, entity);
    }

    public Coordinate findCoordinate(Entity entity) {
        Set<Coordinate> coordinates = entityMap.keySet();
        for (Coordinate coordinate : coordinates) {
            Entity currentEntity = entityMap.get(coordinate);
            if (currentEntity != null && currentEntity.equals(entity)) {
                return coordinate;
            }
        }
        throw new NullPointerException("Ошибка... по заданным координатам нет животных");
    }
}