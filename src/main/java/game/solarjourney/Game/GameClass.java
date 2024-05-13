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

public class GameClass extends Application{
    //public static double start;
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

        executor = Executors.newScheduledThreadPool(3);
        executor.scheduleAtFixedRate(new PlanetControl(controller), 0, 5, TimeUnit.MILLISECONDS);

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
                        //controller.rotateLeft();
                        controller.turnLeft();
                        break;
                    case D:
                        //controller.rotateRight();
                        controller.turnRight();
                        break;
                    case L:
                        System.out.println("wcisniete L");
                        //start = System.currentTimeMillis();
                        //controller.setStart();
                        executor.scheduleAtFixedRate(new Aktualizacja(controller), 0, 1, TimeUnit.MILLISECONDS);
                        executor.scheduleAtFixedRate(new Odmalowanie(controller), 0, 1, TimeUnit.MILLISECONDS);
                        break;
                    case E:
                        controller.landing();
                        System.out.println("Klawisz Escape został naciśnięty");
                        if (executor != null && !executor.isShutdown()) {
                            executor.shutdown();
                        }
                        break;
                    case ESCAPE:
                        System.out.println("Klawisz Escape został naciśnięty");
                        if (executor != null && !executor.isShutdown()) {
                            executor.shutdown();
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
