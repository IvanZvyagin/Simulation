package WorldMap;

import Creature.Herbivore;
import Creature.Predator;
import Entity.*;

public class MapRenderer {
    public static void render(WorldMap map) throws Exception {
        System.out.println();
        for (int i = 0; i < map.getLength(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                Entity currentEntity = map.getEntity(new Coordinate(i,j));
                if(currentEntity instanceof Herbivore){
                    System.out.print(" " + "\uD83D\uDC30" + " ");
                }else if(currentEntity instanceof Predator){
                    System.out.print(" " + "\uD83D\uDC3A" + " ");
                }else if(currentEntity instanceof Grass){
                    System.out.print(" " + "\uD83C\uDF3F" + " ");
                }else if(currentEntity instanceof Rock){
                    System.out.print(" " + "\uD83E\uDEA8" + " ");
                }else if(currentEntity instanceof Tree){
                    System.out.print(" " + "\uD83C\uDF33" + " ");
                }else if(currentEntity == null){
                    System.out.print(" " + "\uD83D\uDFEB" + " ");
                }else{
                    throw new Exception("Неизвестная сущность: " + currentEntity);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
