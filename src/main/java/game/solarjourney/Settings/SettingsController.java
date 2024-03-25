package game.solarjourney.Settings;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;
import game.solarjourney.Settings.SettingsClass;

//Autor: Michał Sieczczyński

public class SettingsController {

    @FXML
    public void switchToMenu(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlloader = new FXMLLoader(SettingsController.class.getResource("/game/solarjourney/Menu/MenuView.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlloader.load());
        stage.setTitle("Settings");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    String key = null;

    @FXML
    protected void keyBind(ActionEvent event)
    {
        Button btn = (Button)event.getSource();
        btn.setText("");
        EventHandler keyBind = new EventHandler()
        {
            @Override
            public void handle(Event event)
            {
                key = ((KeyEvent) event).getText();
                if (key != null )
                {
                    btn.removeEventHandler(KeyEvent.KEY_PRESSED, this);
                    btn.setText(key);
                    key = null;
                }
            }
        };
        btn.addEventHandler(KeyEvent.KEY_PRESSED, keyBind);
    }

    @FXML
    private Button difficulty;

    @FXML
    protected void switchDifficulty(ActionEvent event)
    {
        if(difficulty.getText().equals("Easy"))
            difficulty.setText("Normal");
        else if(difficulty.getText().equals("Normal"))
            difficulty.setText("Hard");
        else if(difficulty.getText().equals("Hard"))
            difficulty.setText("Easy");
    }



    @FXML
    private Button upButton;

    @FXML
    private Button downButton;

    @FXML
    private Button leftButton;

    @FXML
    private Button rightButton;

    @FXML
    private Button takeOffButton;

    @FXML
    private Slider throttleSensitivity;

    @FXML
    private Slider rotateSensitivity;

    SettingsClass SettingsC;
    @FXML
    protected void Save(ActionEvent event)
    {
        SettingsC.difficultyText = difficulty.getText();
        SettingsC.upText = upButton.getText();
        SettingsC.downText = downButton.getText();
        SettingsC.leftText = leftButton.getText();
        SettingsC.rightText = rightButton.getText();
        SettingsC.takeOffText = takeOffButton.getText();
        SettingsC.throttleSensivityValue = (int)throttleSensitivity.getValue();
        SettingsC.rotateSensivityValue = (int)rotateSensitivity.getValue();
    }
}

