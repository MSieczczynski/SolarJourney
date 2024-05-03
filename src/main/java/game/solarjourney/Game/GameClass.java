package game.solarjourney.Game;

import javafx.application.Application;
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
    @Override
    public void run() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameView.fxml"));
        GameController controller = loader.getController();
        controller.fuelLevel();
        controller.velocityLevel();
    }
}
class Odmalowanie implements Runnable{
    @Override
    public void run() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameView.fxml"));
        GameController controller = loader.getController();
        controller.setRB();
        controller.setFuelLevel();
        controller.setVelocity();
    }
}
public class GameClass extends Application{
    public static double start;
    public static String name;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        GameController controller = loader.getController();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //System.out.println(event.getCode());
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
                        start = System.currentTimeMillis();
                        controller.setStart();
                        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
                        executor.scheduleAtFixedRate(new Aktualizacja(), 0, 1, TimeUnit.MILLISECONDS);
                        executor.scheduleAtFixedRate(new Odmalowanie(), 0, 1, TimeUnit.MILLISECONDS);
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
