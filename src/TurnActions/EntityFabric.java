package TurnActions;

import Creature.Herbivore;
import Creature.Predator;
import Entity. *;

import java.util.Random;

public class EntityFabric extends Entity {
    //Вводим переменную для рандома
    private final Random random = new Random();
    //Паттерн: фабричный метод
    public Entity createEntity(EntityType entityType){
        return switch (entityType){
            //создаем сущности без параметров
            case GRASS -> new Grass();
            case ROCK -> new Rock();
            case TREE -> new Tree();
            //создаем хищника и травоядного с рандомными показателями(здоровье и скорость в одном диапазоне)
            case PREDATOR -> new Predator(random.nextInt(3) + 2, random.nextInt(5) + 2,
                    random.nextInt(5)+3);
            case HERBIVORE -> new Herbivore(random.nextInt(1) + 5, random.nextInt(5)+2);
            default -> throw new IllegalArgumentException("Переданный тип сущности не существует" + entityType);
        };
    }
}
