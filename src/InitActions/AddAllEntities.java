package InitActions;

import Entity.EntityType;
import TurnActions.AddEntity;
import WorldMap.WorldMap;

public class AddAllEntities implements Action{
    @Override
    public synchronized void perform(WorldMap map) {
        //добавляем все известные сущности на карту в % соотношении от общего размера карты
        int sizeMap = map.getLength() * map.getWidth();
        new AddEntity().add(map,sizeMap / 6, EntityType.HERBIVORE)
                .add(map,sizeMap / 10, EntityType.PREDATOR)
                .add(map, sizeMap / 7, EntityType.GRASS)
                .add(map, sizeMap / 10, EntityType.ROCK)
                .add(map,sizeMap / 10, EntityType.TREE);
    }
}
