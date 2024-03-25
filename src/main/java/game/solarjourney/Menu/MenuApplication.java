package game.solarjourney.Menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(MenuApplication.class.getResource("/game/solarjourney/Menu/MenuView.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));To samo co nizej
        Scene scene = new Scene(fxmlloader.load());
        stage.setTitle("Solar Journey");
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
