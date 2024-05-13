package game.solarjourney.Game;

import game.solarjourney.Menu.MenuController;
import game.solarjourney.Settings.SettingsClass;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;

//Autor: Anna Kodym
public class GameController{
    protected static double fuel = 100;
    //public double t;
    //public double start;
    public static double vx;
    public static double vy;
    public static double v = 1;
    public static double vLanding;
    public static double rotationSpeed = 0;
    public double[] distance = new double[5];
    public double[]  gravitationalForce = new double[5];

    private int f; // do przekazywania czy prędkość jest dobra
    public double t;
    public double start;
    //public static double v = 1.0;
    public static int l = 1; //do przekazywania poziomu trudności 1-łatwy, 2-średmi 2-trudny
    @FXML
    public Button menu;
    @FXML
    public Label fuelLabel;
    @FXML
    public Label velocityLabel;
    @FXML
    public Label velocityControlLabel;

    /*
    @FXML
    public Circle rocket;
     */
    @FXML
    public Rectangle rocket;
    @FXML
    public Circle velocityControl;

    @FXML
    public Circle slonce;
    @FXML
    public Circle slonceSiatka;
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


    public Collision vsPlanet = new Collision();

    public static double[] dt = {0,0,0,0};
    public static double[] vPlanet = new double[8];
    public void planetPosition()
    {
        wenus.setLayoutX(wenus.getLayoutX() + vPlanet[0]);
        wenus.setLayoutY(wenus.getLayoutY() + vPlanet[1]);
        wenusSiatka.setLayoutX(wenusSiatka.getLayoutX() + vPlanet[0]);
        wenusSiatka.setLayoutY(wenusSiatka.getLayoutY() + vPlanet[1]);


        ziemia.setLayoutX(ziemia.getLayoutX() + vPlanet[2]);
        ziemia.setLayoutY(ziemia.getLayoutY() + vPlanet[3]);
        ziemiaSiatka.setLayoutX(ziemiaSiatka.getLayoutX() + vPlanet[2]);
        ziemiaSiatka.setLayoutY(ziemiaSiatka.getLayoutY() + vPlanet[3]);


        mars.setLayoutX(mars.getLayoutX() + vPlanet[4]);
        mars.setLayoutY(mars.getLayoutY() + vPlanet[5]);
        marsSiatka.setLayoutX(marsSiatka.getLayoutX() + vPlanet[4]);
        marsSiatka.setLayoutY(marsSiatka.getLayoutY() + vPlanet[5]);

        jowisz.setLayoutX(jowisz.getLayoutX() + vPlanet[6]);
        jowisz.setLayoutY(jowisz.getLayoutY() + vPlanet[7]);
        jowiszSiatka.setLayoutX(jowiszSiatka.getLayoutX() + vPlanet[6]);
        jowiszSiatka.setLayoutY(jowiszSiatka.getLayoutY() + vPlanet[7]);


        /* Ruch planet bez wycentrowania statku
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
         */
    }
    public void planetStartPosition(double s1, double s2, double s3, double s4)
    {
        dt[0] = s1;
        dt[1] = s2;
        dt[2] = s3;
        dt[3] = s4  ;

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

    public void planetSpeedEvaluation()
    {
        dt[0] += 0.0001;
        dt[1] += 0.00007;
        dt[2] += 0.00004;
        dt[3] += 0.00001;

        vPlanet[0] = (0.00291196*Math.sin(dt[0]))/Math.pow(1+0.06772*Math.cos(dt[0]),2)*Math.cos(dt[0]) - 0.043/(1+0.06772*Math.cos(dt[0]))*Math.sin(dt[0]);
        vPlanet[1] = (0.00291196*Math.sin(dt[0]))/Math.pow(1+0.06772*Math.cos(dt[0]),2)*Math.sin(dt[0]) + 0.043/(1+0.06772*Math.cos(dt[0]))*Math.cos(dt[0]);

        vPlanet[2] = (0.000941547*Math.sin(dt[1]))/Math.pow(1+0.0167089*Math.cos(dt[1]),2)*Math.cos(dt[1]) - 0.05635/(1+0.0167089*Math.cos(dt[1]))*Math.sin(dt[1]);
        vPlanet[3] = (0.000941547*Math.sin(dt[1]))/Math.pow(1+0.0167089*Math.cos(dt[1]),2)*Math.sin(dt[1]) + 0.05635/(1+0.0167089*Math.cos(dt[1]))*Math.cos(dt[1]);

        vPlanet[4] = (0.00444584*Math.sin(dt[2]))/Math.pow(1+0.0934*Math.cos(dt[2]),2)*Math.cos(dt[2]) - 0.0476/(1+0.0934*Math.cos(dt[2]))*Math.sin(dt[2]);
        vPlanet[5] = (0.00444584*Math.sin(dt[2]))/Math.pow(1+0.0934*Math.cos(dt[2]),2)*Math.sin(dt[2]) + 0.0476/(1+0.0934*Math.cos(dt[2]))*Math.cos(dt[2]);

        vPlanet[6] = (0.000775065*Math.sin(dt[3]))/Math.pow(1+0.0489*Math.cos(dt[3]),2)*Math.cos(dt[3]) - 0.01585/(1+0.0489*Math.cos(dt[3]))*Math.sin(dt[3]);
        vPlanet[7] = (0.000775065*Math.sin(dt[3]))/Math.pow(1+0.0489*Math.cos(dt[3]),2)*Math.sin(dt[3]) + 0.01585/(1+0.0489*Math.cos(dt[3]))*Math.cos(dt[3]);
    }

    public void planetGravitionalForce()
    {
        distance[0] = Math.sqrt(Math.pow(rocket.getLayoutX() - slonce.getLayoutX(),2) + Math.pow(rocket.getLayoutY() - slonce.getLayoutY(),2));
        distance[1] = Math.sqrt(Math.pow(rocket.getLayoutX() - wenus.getLayoutX(),2) + Math.pow(rocket.getLayoutY() - wenus.getLayoutY(),2));
        distance[2] = Math.sqrt(Math.pow(rocket.getLayoutX() - ziemia.getLayoutX(),2) + Math.pow(rocket.getLayoutY() - ziemia.getLayoutY(),2));
        distance[3] = Math.sqrt(Math.pow(rocket.getLayoutX() - mars.getLayoutX(),2) + Math.pow(rocket.getLayoutY() - mars.getLayoutY(),2));
        distance[4] = Math.sqrt(Math.pow(rocket.getLayoutX() - jowisz.getLayoutX(),2) + Math.pow(rocket.getLayoutY() - jowisz.getLayoutY(),2));

        gravitationalForce[0] = 10/Math.pow(distance[0],2);
        gravitationalForce[1] = 0.45/Math.pow(distance[1],2);
        gravitationalForce[2] = 0.5/Math.pow(distance[2],2);
        gravitationalForce[3] = 0.19/Math.pow(distance[3],2);
        gravitationalForce[4] = 1.18/Math.pow(distance[4],2);

        if(distance[0] <= 200)
        {
            vx += ((slonce.getLayoutX() - rocket.getLayoutX()) / (distance[0])) * gravitationalForce[0];
            vy += ((slonce.getLayoutY() - rocket.getLayoutY()) / (distance[0])) * gravitationalForce[0];
        }
        if(distance[1] <= 180)
        {
            vx += ((wenus.getLayoutX()-rocket.getLayoutX())/(distance[1]))*gravitationalForce[1];
            vy += ((wenus.getLayoutY()-rocket.getLayoutY())/(distance[1]))*gravitationalForce[1];
            vLanding = Math.sqrt(Math.pow(vx-vPlanet[0],2) + Math.pow(vy-vPlanet[1],2));
        }
        if(distance[2] <= 186)
        {
            vx += ((ziemia.getLayoutX()-rocket.getLayoutX())/(distance[2]))*gravitationalForce[2];
            vy += ((ziemia.getLayoutY()-rocket.getLayoutY())/(distance[2]))*gravitationalForce[2];
            vLanding = Math.sqrt(Math.pow(vx-vPlanet[2],2) + Math.pow(vy-vPlanet[3],2));
        }
        if(distance[3] <= 96)
        {
            vx += ((mars.getLayoutX()-rocket.getLayoutX())/(distance[3]))*gravitationalForce[3];
            vy += ((mars.getLayoutY()-rocket.getLayoutY())/(distance[3]))*gravitationalForce[3];
            vLanding = Math.sqrt(Math.pow(vx-vPlanet[4],2) + Math.pow(vy-vPlanet[5],2));
        }
        if(distance[4] <= 300)
        {
            vx += ((jowisz.getLayoutX()-rocket.getLayoutX())/(distance[4]))*gravitationalForce[4];
            vy += ((jowisz.getLayoutY()-rocket.getLayoutY())/(distance[4]))*gravitationalForce[4];
            vLanding = Math.sqrt(Math.pow(vx-vPlanet[6],2) + Math.pow(vy-vPlanet[7],2));
        }
    }
   // public void velocityLevel(){
        //int w = 10/l; //póki co wartość przypadkowa do ustalenia
        //if(v <= 5 && v >= -5){

    public void fuelLevel(double power)
    {
        fuel -= power*(10*SettingsClass.difficultyInt)/(500);
    }

    public void velocityLevel() {
        double w = 0.1/SettingsClass.difficultyInt;
         //if(vLanding < w){
        if(v < 3 && v > -3){
            f = 2;
         }
         else{
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

    /*

    public void setStart()
    {
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
    }*/

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
    }/*
    public void goUp(){
        if(rocket.getTranslateY() - 0.005*v > -450 && rocket.getTranslateY() - 0.015*v < 170){
            rocket.setTranslateY(rocket.getTranslateY() - 0.015*v);
        }
        else{
            rocket.setTranslateY(rocket.getTranslateY());
        }
    }*/
    public void throttleUp(){
        v = v + 1;
    }
    public void throttleDown(){
        v = v - 1;
    }

/*
    public void rotateLeft()
    {
        rotationSpeed -= 0.01;
    }
    public void rotateRight()
    {
        rotationSpeed += 0.01;
    }
*/
    public void rotation()
    {
        rocket.setRotate(rocket.getRotate() + rotationSpeed);
    }
    public void rocketMotion()
    {
       // v = Math.sqrt(Math.pow(vx,2) + Math.pow(vy,2))*1000;

        slonce.setLayoutX(slonce.getLayoutX() - vx);
        slonce.setLayoutY(slonce.getLayoutY() - vy);
        slonceSiatka.setLayoutX(slonceSiatka.getLayoutX() - vx);
        slonceSiatka.setLayoutY(slonceSiatka.getLayoutY() - vy);

        wenus.setLayoutX(wenus.getLayoutX() - vx);
        wenus.setLayoutY(wenus.getLayoutY() - vy);
        wenusSiatka.setLayoutX(wenusSiatka.getLayoutX() - vx);
        wenusSiatka.setLayoutY(wenusSiatka.getLayoutY() - vy);

        ziemia.setLayoutX(ziemia.getLayoutX() - vx);
        ziemia.setLayoutY(ziemia.getLayoutY() - vy);
        ziemiaSiatka.setLayoutX(ziemiaSiatka.getLayoutX() - vx);
        ziemiaSiatka.setLayoutY(ziemiaSiatka.getLayoutY() - vy);

        mars.setLayoutX(mars.getLayoutX() - vx);
        mars.setLayoutY(mars.getLayoutY() - vy);
        marsSiatka.setLayoutX(marsSiatka.getLayoutX() - vx);
        marsSiatka.setLayoutY(marsSiatka.getLayoutY() - vy);

        jowisz.setLayoutX(jowisz.getLayoutX() - vx);
        jowisz.setLayoutY(jowisz.getLayoutY() - vy);
        jowiszSiatka.setLayoutX(jowiszSiatka.getLayoutX() - vx);
        jowiszSiatka.setLayoutY(jowiszSiatka.getLayoutY() - vy);

        if(distance[0] <= 200)
        {
            if(vsPlanet.collisonCheck(rocket.getRotate(),slonce.getLayoutX(),slonce.getLayoutY(),100))
            {
                vx = 0;
                vy = 0;
            }
        }
        if(distance[1] <= 180)
        {
            if(vsPlanet.collisonCheck(rocket.getRotate(),wenus.getLayoutX(),wenus.getLayoutY(),30))
            {
                vx = 0;
                vy = 0;
            }
        }
        if(distance[2] <= 186)
        {
            if(vsPlanet.collisonCheck(rocket.getRotate(),ziemia.getLayoutX(),ziemia.getLayoutY(),31))
            {
                vx = 0;
                vy = 0;
            }
        }
        if(distance[3] <= 96)
        {
            if(vsPlanet.collisonCheck(rocket.getRotate(),mars.getLayoutX(),mars.getLayoutY(),25))
            {
                vx = 0;
                vy = 0;
            }
        }
        if(distance[4] <= 300)
        {
            if(vsPlanet.collisonCheck(rocket.getRotate(),jowisz.getLayoutX(),jowisz.getLayoutY(),50))
            {
                vx = 0;
                vy = 0;
            }
        }
    }
    /*
    public void throttleUp()
    {
        vx = vx + 0.001*Math.sin(Math.toRadians(rocket.getRotate()));
        vy = vy - 0.001*Math.cos(Math.toRadians(rocket.getRotate()));
    }
    public void throttleDown()
    {
        vx = vx - 0.0005*Math.sin(Math.toRadians(rocket.getRotate()));
        vy = vy + 0.0005*Math.cos(Math.toRadians(rocket.getRotate()));
    }*/
    public void landing(){
        if(f == 2){
            System.out.println("Udalo sie wyladowac");
        }
        else{
            System.out.println("Rakieta sie rozbila");
        }
    }
}
