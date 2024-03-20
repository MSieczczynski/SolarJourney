package game.solarjourney.Menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MenuApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL url = getClass().getResource("MenuView.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        if(loader == null){
            throw new RuntimeException("Could not find" + url.toString());
        }
        Scene scene = new Scene(loader.load());
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch();
    }
}
