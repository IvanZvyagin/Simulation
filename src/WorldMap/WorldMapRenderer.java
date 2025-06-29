package WorldMap;

import Creature.Herbivore;
import Creature.Predator;
import Entity.*;

public class WorldMapRenderer {
    public void render(WorldMap map) throws Exception {
        System.out.println();
        for (int i = 0; i < map.getLength(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                Entity currentEntity = map.getEntity(new Coordinate(i,j));
                if(currentEntity instanceof Herbivore){
                    System.out.println(" " + EntityType.HERBIVORE + " ");
                }else if(currentEntity instanceof Predator){
                    System.out.println(" " + EntityType.PREDATOR);
                }else if(currentEntity instanceof Grass){
                    System.out.println(" " + EntityType.GRASS);
                }else if(currentEntity instanceof Rock){
                    System.out.println(" " + EntityType.ROCK);
                }else if(currentEntity instanceof Tree){
                    System.out.println(" " + EntityType.TREE);
                }else if(currentEntity == null){
                    System.out.println(" " + EntityType.EMPTY);
                }else{
                    throw new Exception("Неизвестная сущность: " + currentEntity);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
