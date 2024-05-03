package game.solarjourney.Game;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.application.*;

import java.awt.*;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.lang.ModuleLayer.Controller;

import static java.awt.Event.*;
import static java.awt.Event.RIGHT;
import static javafx.scene.input.KeyCode.W;

//Autor: Anna Kodym
public class GameClass extends Application{
    public static String name;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        GameController controller = loader.getController();
        //z yt zrobione
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
                    default:
                        break;
                }
            }
        });


/*
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


        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    moveCircle(0, -10); // Góra
                    break;
                case S:
                    moveCircle(0, 10); // Dół
                    break;
                case A:
                    moveCircle(-10, 0); // Lewo
                    break;
                case D:
                    moveCircle(10, 0); // Prawo
                    break;
                default:
                    break;
            }
        });

 */
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
