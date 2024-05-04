package game.solarjourney.Menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

//Autor: Anna Kodym (poza funkcją opisaną)
public class MenuController {
    private Stage stage;
    @FXML
    public Button exit;
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
    @FXML
    public void switchToGame(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(MenuController.class.getResource("/game/solarjourney/Game/GameView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(fxmlloader.load());
    }
    @FXML
    public void exitProgram(ActionEvent e){
        System.exit(0);
    }
}