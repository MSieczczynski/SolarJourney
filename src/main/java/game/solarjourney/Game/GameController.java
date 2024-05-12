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

    @FXML
    public Circle wenus;
    @FXML
    public Circle wenusSiatka;
    @FXML
    public Circle ziemia;
    @FXML
    public Circle ziemiaSiatka;
    @FXML
    public Circle mars;
    @FXML
    public Circle marsSiatka;
    @FXML
    public Circle jowisz;
    @FXML
    public Circle jowiszSiatka;

    public double[] dt = {0,0,0,0};
    public void planetPosition()
    {
        dt[0] += 0.0001;
        dt[1] += 0.00007;
        dt[2] += 0.00004;
        dt[3] += 0.00001;

        wenus.setLayoutX(430/(1+0.06772*Math.cos(dt[0]))*Math.cos(dt[0]));
        wenus.setLayoutY(430/(1+0.06772*Math.cos(dt[0]))*Math.sin(dt[0]));
        wenusSiatka.setLayoutX(430/(1+0.06772*Math.cos(dt[0]))*Math.cos(dt[0]));
        wenusSiatka.setLayoutY(430/(1+0.06772*Math.cos(dt[0]))*Math.sin(dt[0]));

        ziemia.setLayoutX(805/(1+0.0167086*Math.cos(dt[1]))*Math.cos(dt[1]));
        ziemia.setLayoutY(805/(1+0.0167086*Math.cos(dt[1]))*Math.sin(dt[1]));
        ziemiaSiatka.setLayoutX(805/(1+0.0167086*Math.cos(dt[1]))*Math.cos(dt[1]));
        ziemiaSiatka.setLayoutY(805/(1+0.0167086*Math.cos(dt[1]))*Math.sin(dt[1]));

        mars.setLayoutX(1190/(1+0.0934*Math.cos(dt[2]))*Math.cos(dt[2]));
        mars.setLayoutY(1190/(1+0.0934*Math.cos(dt[2]))*Math.sin(dt[2]));
        marsSiatka.setLayoutX(1190/(1+0.0934*Math.cos(dt[2]))*Math.cos(dt[2]));
        marsSiatka.setLayoutY(1190/(1+0.0934*Math.cos(dt[2]))*Math.sin(dt[2]));

        jowisz.setLayoutX(1585/(1+0.0489*Math.cos(dt[3]))*Math.cos(dt[3]));
        jowisz.setLayoutY(1585/(1+0.0489*Math.cos(dt[3]))*Math.sin(dt[3]));
        jowiszSiatka.setLayoutX(1585/(1+0.0489*Math.cos(dt[3]))*Math.cos(dt[3]));
        jowiszSiatka.setLayoutY(1584/(1+0.0489*Math.cos(dt[3]))*Math.sin(dt[3]));
    }

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
