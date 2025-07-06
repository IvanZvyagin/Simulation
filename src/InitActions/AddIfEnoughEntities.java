package InitActions;

import Creature.Herbivore;
import Entity.EntityType;
import Entity.Grass;
import TurnActions.AddEntity;
import WorldMap.WorldMap;


public class AddIfEnoughEntities implements Action {
    @Override
    public synchronized void perform(WorldMap map) {
        //в этом методе контролируем популяцию травоядных и травы
        int sizeMap = map.getWidth() * map.getLength();
        long population = map.getAllEntities().stream()
                .filter(entity -> entity instanceof Herbivore || entity instanceof Grass)
                .count();

        if (population <= sizeMap) {
            new AddEntity().add(map, sizeMap / 20, EntityType.GRASS)
                    .add(map, sizeMap / 15, EntityType.HERBIVORE);
        }
    }
}
