package game.solarjourney.Game;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import static game.solarjourney.Game.GameController.*;

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
        stage.setResizable(true);
        stage.setFullScreen(false);
        stage.show();
        name = "a";
    }
    public static void main(String[] args){
        launch();
    }
}
