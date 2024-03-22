package game.solarjourney.Game;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GameClass extends  Application{
    public static String name;

    @Override
    public void start(Stage stage) throws IOException {
        URL url = getClass().getResource("GameView.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        if(loader.equals(null)){
            throw new RuntimeException("Could not find" + url.toString());
        }
        Scene scene = new Scene(loader.load());
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.show();
        name = "a";
    }
    public static void main(String[] args){
        launch();
    }
}
