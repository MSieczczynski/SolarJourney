package game.solarjourney.Game;

import game.solarjourney.Menu.MenuController;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.IOException;

//Autor: Anna Kodym
public class GameController{
    protected static double fuel = 100;
    public double t;
    public double start;
    public static double v = 10.0;
    private int f; // do przekazywania czy prędkość jest dobra
    public static int l = 1; //do przekazywania poziomu trudności 1-łatwy, 2-średmi 2-trudny
    @FXML
    public Button menu;
    @FXML
    public Label fuelLabel;
    @FXML
    public Label velocityLabel;
    @FXML
    public Label velocityControlLabel;
    @FXML
    public Circle rocket;
    @FXML
    public Circle velocityControl;
    public void setStart(){
        start = GameClass.start;
    }
    public void fuelLevel() {
        t = System.currentTimeMillis() - this.start;
        fuel = fuel - (Math.abs(v)*t*l)/(100000); //ile zostało paliwa, liczę w procentach stąd dzielenie na 100
    }
    public void velocityLevel(){
        //int w = 10/l; //póki co wartość przypadkowa do ustalenia
        if(v <= 10 && v >= -10){
            f = 2;
        }else{
            f = 1;
        }
    }
    //control check d
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
    @FXML
    public void setFuelLevel(){
        fuelLabel.setText(String.valueOf(fuel+"%"));
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
    public void turnLeft(){
        if(rocket.getTranslateX() > -250){
            rocket.setTranslateX(rocket.getTranslateX() - 10);
        }
        else{
            rocket.setTranslateX(rocket.getTranslateX());
        }
    }
    public void turnRight(){
        if(rocket.getTranslateX() + 10 < 1010){
            rocket.setTranslateX(rocket.getTranslateX() + 10);
        }
        else{
            rocket.setTranslateX(rocket.getTranslateX());
        }
    }
    public void goUp(){
        if(rocket.getTranslateY() - 1*v > -450 && rocket.getTranslateY() - 1*v < 170){
            rocket.setTranslateY(rocket.getTranslateY() - 1*v);
        }
        else{
            rocket.setTranslateY(rocket.getTranslateY());
        }
    }
    public void throttleUp(){
        v = v + 5;
    }
    public void throttleDown(){
        v = v - 5;
    }
}
