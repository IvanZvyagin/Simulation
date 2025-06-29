package Entity;


import WorldMap.Coordinate;

abstract public class Entity {
    EntityType type;
    public Coordinate coordinate;

    public Entity(EntityType type, Coordinate coordinate) {
        this.type = type;
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

}