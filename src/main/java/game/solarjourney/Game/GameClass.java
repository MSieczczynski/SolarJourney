package game.solarjourney.Game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Aktualizacja implements Runnable{
    private GameController controller;
    public Aktualizacja(GameController controller){
        this.controller = controller;
    }
    @Override
    public void run() {
        Platform.runLater(() -> {
            controller.goUp();
            controller.fuelLevel();
            controller.velocityLevel();
        });
    }
}
class Odmalowanie implements Runnable{
    private GameController controller;
    public Odmalowanie(GameController controller){
        this.controller = controller;
    }
    @Override
    public void run() {
        Platform.runLater(() -> {
            controller.setRB();
            controller.setFuelLevel();
            controller.setVelocity();
        });
    }
}

class PlanetControl implements Runnable
{
    private GameController controller;
    public PlanetControl(GameController controller)
    {
        this.controller = controller;
    }

    @Override
    public void run()
    {
        Platform.runLater(() -> {
            controller.planetPosition();
        });
    }
}

public class GameClass extends Application{
    public static double start;
    public static double sceneWidth;
    public double sceneHeight;
    private ScheduledExecutorService executor;
    private ScheduledExecutorService executor1;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameView.fxml"));
        Parent root = loader.load();
        GameController controller = loader.getController();
        Scene scene = new Scene(root);

        executor1 = Executors.newScheduledThreadPool(1);
        executor1.scheduleAtFixedRate(new PlanetControl(controller), 0, 1, TimeUnit.MILLISECONDS);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()){
                    case W:
                        controller.throttleUp();
                        break;
                    case S:
                        controller.throttleDown();
                        break;
                    case A:
                        controller.turnLeft();
                        break;
                    case D:
                        controller.turnRight();
                        break;
                    case L:
                        System.out.println("wcisniete L");
                        start = System.currentTimeMillis();
                        controller.setStart();
                        executor = Executors.newScheduledThreadPool(2);
                        executor.scheduleAtFixedRate(new Aktualizacja(controller), 0, 1, TimeUnit.MILLISECONDS);
                        executor.scheduleAtFixedRate(new Odmalowanie(controller), 1, 1, TimeUnit.MILLISECONDS);
                        break;
                    case E:
                        controller.landing();
                        System.out.println("Klawisz Escape został naciśnięty");
                        if (executor != null && !executor.isShutdown()) {
                            executor.shutdown();
                            executor1.shutdown();
                        }
                        break;
                    case ESCAPE:
                        System.out.println("Klawisz Escape został naciśnięty");
                        if (executor != null && !executor.isShutdown()) {
                            executor.shutdown();
                            executor1.shutdown();
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setFullScreen(false);
        stage.show();

    }
    public static void main(String[] args){
        launch();
    }
}
