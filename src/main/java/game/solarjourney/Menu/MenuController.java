package game.solarjourney.Menu;

import game.solarjourney.Game.*;
import game.solarjourney.Settings.SettingsClass;
import game.solarjourney.Settings.SettingsController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static game.solarjourney.Game.GameController.*;

//Autor: Anna Kodym (poza funkcją opisaną)
public class MenuController {
    private Stage stage;
    public static ScheduledExecutorService executor;
    @FXML
    public Button exit;

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
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(fxmlloader.load());

    }

    @FXML
    public void switchToGame(ActionEvent event) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(MenuController.class.getResource("/game/solarjourney/Game/GameView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(fxmlloader.load());
        GameController controller = fxmlloader.getController();
        Scene scene = stage.getScene();

        controller.planetStartPosition(0,0,0,0);
        executor = Executors.newScheduledThreadPool(3);
        executor.scheduleAtFixedRate(new PlanetControl(controller), 0, 1, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new Aktualizacja(controller), 0, 1, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new Odmalowanie(controller), 0, 1, TimeUnit.MILLISECONDS);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()){
                    case L:
                        if(!landingSuccess) {
                            controller.starting();
                        }
                    case W:
                        controller.throttleUp();
                        controller.fuelLevel(1);
                        break;
                    case S:
                        controller.throttleDown();
                        controller.fuelLevel(0.5);
                        break;
                    case A:
                        controller.rotateLeft();
                        controller.fuelLevel(0.2);
                        break;
                    case D:
                        controller.rotateRight();
                        controller.fuelLevel(0.2);
                        break;
                    case ESCAPE:
                        System.out.println("Klawisz Escape został naciśnięty");
                        if (executor != null && !executor.isShutdown()) {
                            executor.shutdown();
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        stage.setTitle("Solar Journey");
        stage.setResizable(true);
        stage.setFullScreen(false);
        stage.show();



    }
    @FXML
    public void exitProgram(ActionEvent e){
        System.exit(0);
    }
}