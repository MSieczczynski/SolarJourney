package game.solarjourney.Game;

import game.solarjourney.Menu.MenuController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

//Autor: Anna Kodym
public class GameController{
    protected static double fuel;
    public static double t;
    public static double v = 10.0;
    private int f; // do przekazywania czy prędkość jest dobra
    public static int l; //do przekazywania poziomu trudności 1-łatwy, 2-średmi 2-trudny
    @FXML
    public Button menu;
    @FXML
    public Label fuelLabel;
    @FXML
    public Label velocityLabel;
    @FXML
    public Label velocityControlLabel;
    @FXML
    public Circle rocket; //będzie udawało rakietę by pokazać że działa ruszanie
    @FXML
    public Circle velocityControl;
    public void fuelLevel() {
        t = t + 0.001;
        fuel = fuel - (v*t*l)/(100); //ile zostało paliwa, liczę w procentach stąd dzielenie na 100
    }
    public void velocityLevel(){
        int w = 100/l;
        if(v > w){ // 300 to przypadkowa wartość do ustalenia potem
            f = 2;
        }else{
            f = 1;
        }
    }
    @FXML
    public void setVelocity(){
        velocityLabel.setText(String.valueOf(v));
    }
    @FXML
    public void setRB(){
        velocityControl.setVisible(false);
        if(f == 1){
            velocityControl.setVisible(true);
        }
    }
    public void moveRocket(ActionEvent e){
        //do doczytania jak skoordynować z wciskanymi klawiszami
    }
    @FXML
    public void setFuelLevel(){
        //do doczytania jak ustawić poziom na progress bar
        fuel = 0.5;
        fuelLabel.setText(String.valueOf(fuel));
    }
    @FXML
    public void toMenu(ActionEvent e)throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(MenuController.class.getResource("/game/solarjourney/Menu/MenuView.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlloader.load());
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setFullScreen(false);
        stage.show();
    }
}
