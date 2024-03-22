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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static game.solarjourney.Game.GameClass.name;

public class MenuController {

    private Stage stage;
    private Scene scene;
    @FXML
    public RadioButton polRB;
    @FXML
    public RadioButton angRB;

    @FXML
    private TextField field;

    @FXML
    public void switchToSettings(ActionEvent event) throws IOException {
        //Autor:Michał Sieczczyński
        /*
        FXMLLoader fxmlloader = new FXMLLoader(MenuController.class.getResource("/game/solarjourney/Settings/SettingsView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlloader.load());
        stage.setScene(scene);
        stage.show();
         */
        FXMLLoader fxmlloader = new FXMLLoader(MenuController.class.getResource("/game/solarjourney/Settings/SettingsView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(fxmlloader.load());
    }

    public void switchToGame()
    {

    }
    @FXML
    private Label welcomeText;
    @FXML
    public void setName(ActionEvent e) throws IOException{
        name = field.getText();
        System.out.println(name);
    }

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}