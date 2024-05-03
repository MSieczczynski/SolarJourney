package game.solarjourney.Game;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.application.*;
import java.io.IOException;
import java.net.URL;
import java.lang.ModuleLayer.Controller;
//Autor Anna Kodym
public class GameClass extends  Application{
    public static String name;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameView.fxml"));
        Parent root = loader.load();

        //Controller GameController = loader.getController(); na potem
        Scene scene = new Scene(root);
/* na potem
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent keyEvent) {
                switch(keyEvent.getCode()){
                    case D:
                        GameController.turnLeft();
                        break;
                    case A:
                        GameController.turnRight();
                        break;
                    case W:
                        GameController.throttleUp();
                        break;
                    case S:
                        GameController.throttleDown();
                        break;
                    default:
                        break;
                }
            }
        });

 */
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setFullScreen(false);
        stage.show();
        name = "a";
    }
    public static void main(String[] args){
        launch();
    }
}
