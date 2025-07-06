package InitActions;

import Entity.EntityType;
import WorldMap.WorldMap;

public class AddEntity {
    //метод для добавления на карту сущностей
    public synchronized AddEntity add(WorldMap map, int numberEntity, EntityType entityType) {
        EntityFabric entityFabric = new EntityFabric();
        for (int i = 0; i < numberEntity; i++) {
        }
        return this;
    }
}
