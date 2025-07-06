package TurnActions;

import Creature.Creature;
import Entity.Entity;
import Entity.EntityType;
import WorldMap.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class MakeMoveCreature implements Action{
    @Override
    public void perform(WorldMap map) {
        //Создаем новый список движений
        List<Creature> creaturesToMove = new ArrayList<>();
        for (Entity entity : map.getAllEntities()){
            if(entity instanceof Creature){
                creaturesToMove.add((Creature) entity);
            }
        }
        //Проверка, если существо не мертво, делает метод makeMove
        creaturesToMove.forEach(entity ->{
            if(!entity.isDead()){
                entity.makeMove(map);
            }
        });
    }
}
