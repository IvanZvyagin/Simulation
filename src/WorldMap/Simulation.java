package WorldMap;

import InitActions.Action;
import InitActions.AddAllEntities;
import InitActions.AddIfEnoughEntities;
import InitActions.MakeMoveCreature;

import java.util.List;
import java.util.Scanner;

public class Simulation {
    private WorldMap map;
    private int moveCounter = 0;
    private static final int COMMAND_STOP = 0;
    private static final int COMMAND_PAUSE = 1;
    private static final int COMMAND_ONETURN = 2;
    private boolean pause = false;
    private List<Action> initActions = List.of(new AddAllEntities());
    private List<Action> turnActions = List.of(new MakeMoveCreature(), new AddIfEnoughEntities());

    public Simulation(int lengthX, int widthY) {
        this.map = new WorldMap(lengthX, widthY);
    }

    public WorldMap getMap() {
        return map;
    }

    public void nextTurn(WorldMap map) throws Exception {
        MapRenderer.render(map);
        System.out.printf("%d - Остановка симуляции \n%d - Пауза симуляции  " +
                        "\n%d - Один ход симуляции" + "\n(Текущий ход: %d) \n", COMMAND_STOP, COMMAND_PAUSE,
                COMMAND_ONETURN, moveCounter);
        turnActions.forEach(action -> action.perform(map));
        moveCounter++;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void startSimulation(WorldMap map) throws Exception {
        boolean continueSimulatioun = true;
        initActions.forEach(action -> action.perform(map));
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    while (pause)
                        Thread.sleep(100);
                    nextTurn(map);
                    Thread.sleep(4000);
                } catch (Exception e) {
                    return;
                }
            }
        });

        thread.start();
        while (continueSimulatioun) {
            int userInput = userInput();
            System.out.println();
            switch (userInput) {
                case (COMMAND_PAUSE):
                    pause();
                    break;
                case (COMMAND_ONETURN):
                    nextTurn(map);
                case (COMMAND_STOP):
                    continueSimulatioun = false;
                    System.out.println("Симуляция остановлена");
                    System.exit(0);
            }
        }
        Thread.interrupted();
    }

    private int userInput() {
        Scanner input = new Scanner(System.in);
        int command;
        while (true) {
            try {
                command = Integer.parseInt(input.next());
                pause = true;
                if (command == COMMAND_PAUSE || command == COMMAND_STOP) {
                    pause = false;
                    break;
                } else {
                    System.out.println("Такой команды нет, попробуете другую?");
                }
            } catch (Exception e) {
                System.out.println("Неизвестная команда, попробуйте еще раз");
                pause = true;
            }
        }
        return command;
    }

    private void pause() {
        pause = true;
        System.out.println("Пауза. Нажмите Enter для продолжения, либо напишите любую букву");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        pause = false;
    }

    private void oneTurn() throws Exception {
        System.out.printf("Введите %d для одной итерации хода", COMMAND_ONETURN);
        Scanner in = new Scanner(System.in);
        in.nextInt();
        MapRenderer.render(map);
        turnActions.forEach(action -> action.perform(map));
    }
}
