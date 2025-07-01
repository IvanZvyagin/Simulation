package InitActions;

import Creature.Herbivore;
import Creature.Predator;
import Entity. *;

import java.util.Random;

public class EntityFabric {
    private final Random random = new Random();
    public Entity createEntity(EntityType entityType){
        return switch (entityType){
            case GRASS -> new Grass();
            case ROCK -> new Rock();
            case TREE -> new Tree();
            case PREDATOR -> new Predator(random.nextInt(10) + 5, random.nextInt(5) + 2,
                    random.nextInt(5)+3);
            case HERBIVORE -> new Herbivore(random.nextInt(10) + 5, random.nextInt(5)+2);
            default -> throw new IllegalArgumentException("Переданный тип сущности не существует" + entityType);
        };
    }
}
