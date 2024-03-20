package game.solarjourney.Menu;

import game.solarjourney.Game.GameClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    private Stage stage;
    private Scene scene;
    @FXML
    private TextField field;

    @FXML
    public void switchToSettings(ActionEvent event) throws IOException {
        //Autor:Michał Sieczczyński
        FXMLLoader fxmlloader = new FXMLLoader(MenuController.class.getResource("/game/solarjourney/Settings/SettingsView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlloader.load());
        stage.setScene(scene);
        stage.show();
        /*
        Robi to samo co powyżej uzywajac setRoot.
        FXMLLoader fxmlloader = new FXMLLoader(MenuController.class.getResource("/game/solarjourney/Settings/SettingsView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(fxmlloader.load());
         */
    }

    public void switchToGame()
    {

    }
    @FXML
    private Label welcomeText;
    @FXML
    public void setName(ActionEvent e) throws IOException{
        GameClass.name = field.getText();
        System.out.println(GameClass.name);
    }

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}