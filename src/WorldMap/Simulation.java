package WorldMap;

public class Simulation {
    private WorldMap map;
    private int moveCounter = 0;
    private static final String COMMAND_START = "Start";
    private static final String COMMAND_PAUSE = "Pause";
    private boolean pause = false;
    public Simulation(int lengthX,int widthY){
        this.map = new WorldMap(lengthX,widthY);
    }
}
