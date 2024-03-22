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
    private double fuel;
    private double t;
    private double v = 10.0;
    private int f; // do przekazywania czy prędkość jest dobra
    //public ButtonGroup group; znajdź jak to dla fx
    public int l; //do przekazywania poziomu trudności 1-łatwy, 2-średmi 2-trudny
    @FXML
    public RadioButton yesRB;
    @FXML
    public RadioButton noRB;
    @FXML
    public ProgressBar fuelLevel;
    @FXML
    public Text fieldVelocity;
    @FXML
    public Circle rocket; //będzie udawało rakietę by pokazać że działa ruszanie
    public void fuelLevel() {
        t = t + 0.001;
        fuel = fuel - (v*t*l)/(100); //ile zostało paliwa, liczę w procentach stąd dzielenie na 100
    }
    public void velocityLevel(){
        int w = 100/l;
        if( v > w){ // 300 to przypadkowa wartość do ustalenia potem
            f = 2;
        }else{
            f = 1;
        }
    }
    @FXML
    public void setVelocity(){
        fieldVelocity.setText(String.valueOf(v));
    }
    @FXML
    public void setRB(){
        if(f == 1){
            yesRB.selectedProperty();
        } else if (f == 2) {
            noRB.selectedProperty();
        }
    }
    public void moveRocket(ActionEvent e){
        //do doczytania jak skoordynować z wciskanymi klawiszami
    }
    public void setFuelLevel(){
        //do doczytania jak ustawić poziom na progress bar
    }
}
