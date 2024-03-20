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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

//Autor: Anna Kodym
public class GameController{
    double fuel;
    double t;
    double v;
    int f; // do przekazywania czy prędkość jest dobra
    public void fuelLevel() {
        t = t + 0.001;
        fuel = fuel - (v*t)/100; //ile zostało paliwa, liczę w procentach stąd dzielenie na 100
    }
    public void velocityLevel(){
        if( v > 300){ // 300 to przypadkowa wartość do ustalenia potem
            f = 2;
        }else{
            f = 1;
        }
    }
    public void setVelocity(){
        /*
        textfiels = v.toString(); tutaj schematycznie do dorobienia

         */
    }
}
