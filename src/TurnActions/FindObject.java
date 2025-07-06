package TurnActions;

import Entity.Entity;
import WorldMap.Coordinate;
import WorldMap.WorldMap;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FindObject {
    public static List<Coordinate> find(WorldMap map, Entity initialEntity, Class<? extends Entity> type){
        //создание очереди, для хранения путей
        ArrayDeque<List<Coordinate>> roads = new ArrayDeque<>();
        //создается список посещенный координат
        ArrayList<Coordinate> visitedCoordinate = new ArrayList<>();
        //добавление начальной координаты, конкретной сущности
        roads.add(List.of(map.findCoordinate(initialEntity)));

        while(!roads.isEmpty()) {
            List<Coordinate> currentRoads = roads.pop();
            Coordinate lastCoordinate = currentRoads.get(currentRoads.size() - 1);
            for (Coordinate neighboringCoordinate : findNeighboringCoordinate(lastCoordinate, map)) {
                Entity currentEntity = map.getEntity(neighboringCoordinate);
                //нужно добавить проверки на пустоту
                if (currentEntity == null) {
                    if (!visitedCoordinate.contains(neighboringCoordinate)) {
                        visitedCoordinate.add(neighboringCoordinate);
                        //путь через пустую клетку
                        addNewRoad(roads, currentRoads, neighboringCoordinate);
                    }
                    //проверку на найденную целевую сущность
                } else if (type.isAssignableFrom(currentEntity.getClass())) {
                    return getFoundPath(currentRoads, neighboringCoordinate);
                }
            }
            if (roads.isEmpty()) {
                return new ArrayList<>();
            }
        }
        throw new NullPointerException("К сожалению, путь не найден");
    }

    private static List<Coordinate> getFoundPath(List<Coordinate> currentRoads, Coordinate neighboringCoordinate) {
        List<Coordinate>foundPath = new ArrayList<>(currentRoads);
        foundPath.add(neighboringCoordinate);
        foundPath.removeFirst();
        return foundPath;
    }

    private static List<Coordinate> findNeighboringCoordinate(Coordinate lastCoord, WorldMap map){
        //поиск соседних координат от начальной точки в 8 направлениях
        List<Coordinate>neighboringCoordinate = new ArrayList<>();
        int[][] coordinateNeighbors = {{-1,0},{1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        for(int[]coordinate : coordinateNeighbors){
            int nX = lastCoord.getX() + coordinate[0];
            int nY = lastCoord.getY() + coordinate[1];
            //проверка на выход за пределы карты
            if(nX >= 0 && nX < map.getLength() &&
            nY >= 0 && nY < map.getWidth()){
                neighboringCoordinate.add(new Coordinate(nX,nY));
            }
        }
        return neighboringCoordinate;
    }

    //создает новый путь, на основе текущего
    private static void addNewRoad(ArrayDeque<List<Coordinate>> roads,List<Coordinate>currentRoad,
                                   Coordinate neighboringCoordinate){
        List<Coordinate> newPath = new ArrayList<>();
        newPath.add(neighboringCoordinate);
        roads.add(newPath);
    }

}
