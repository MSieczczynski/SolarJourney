package game.solarjourney.Settings;

import game.solarjourney.Menu.MenuController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.xml.stream.EventFilter;
import java.io.IOException;

//Autor: Michał Sieczczyński

public class SettingsController {
    String key = null;

    @FXML
    public void switchToMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(MenuController.class.getResource("/game/solarjourney/Menu/MenuView.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlloader.load());
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }


    @FXML
    protected void keyBind(ActionEvent event)
    {
        Button btn = (Button) event.getSource();
        btn.setText("");
        EventHandler keyBind = new EventHandler()
        {
            @Override
            public void handle(Event event)
            {
                key = ((KeyEvent) event).getText();
                if (key != null)
                {
                    btn.removeEventHandler(KeyEvent.KEY_PRESSED, this);
                    btn.setText(key);
                    key = null;
                }
            }
        };
        btn.addEventHandler(KeyEvent.KEY_PRESSED, keyBind);
    }
}

