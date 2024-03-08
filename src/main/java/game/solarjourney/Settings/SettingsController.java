package game.solarjourney.Settings;

import game.solarjourney.Menu.MenuController;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

//Autor: Michał Sieczczyński

public class SettingsController
{
    @FXML
    public void switchToMenu(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(MenuController.class.getResource("/game/solarjourney/Menu/MenuView.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlloader.load());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void throttleUp(ActionEvent event)
    {

    }

    @FXML
    protected void throttleDown()
    {

    }

    @FXML
    protected void turnLeft()
    {

    }

    @FXML
    protected void turnRight()
    {

    }
}
