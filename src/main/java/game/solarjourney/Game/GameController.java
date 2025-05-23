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

//Autor: Anna Kodym i Michał Sieczczyński
public class GameController{
    protected static double fuel = 100;
    public static double vx = 0;
    public static double vy = 0;
    public static double v = 0;
    public static double vLanding;
    public static double rotationSpeed = 0;
    public static double throttleDifferential = 1;
    public static boolean landingSuccess = true;
    public int l;
    public double[] distance = new double[5];
    public double[]  gravitationalForce = new double[5];
    private int f; // do przekazywania czy prędkość jest dobra

    @FXML
    public Label gameOver;
    @FXML
    public Label SLanding;
    @FXML
    public Button menu;
    @FXML
    public Label fuelLabel;
    @FXML
    public Label velocityLabel;
    @FXML
    public Label velocityControlLabel;

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

    public static double[] dphi = {0,0,0,0};
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
        dphi[0] = s1;
        dphi[1] = s2;
        dphi[2] = s3;
        dphi[3] = s4;

        wenus.setLayoutX(430/(1+0.06772*Math.cos(dphi[0]))*Math.cos(dphi[0]));
        wenus.setLayoutY(430/(1+0.06772*Math.cos(dphi[0]))*Math.sin(dphi[0]));
        wenusSiatka.setLayoutX(430/(1+0.06772*Math.cos(dphi[0]))*Math.cos(dphi[0]));
        wenusSiatka.setLayoutY(430/(1+0.06772*Math.cos(dphi[0]))*Math.sin(dphi[0]));

        ziemia.setLayoutX(805/(1+0.0167086*Math.cos(dphi[1]))*Math.cos(dphi[1]));
        ziemia.setLayoutY(805/(1+0.0167086*Math.cos(dphi[1]))*Math.sin(dphi[1]));
        ziemiaSiatka.setLayoutX(805/(1+0.0167086*Math.cos(dphi[1]))*Math.cos(dphi[1]));
        ziemiaSiatka.setLayoutY(805/(1+0.0167086*Math.cos(dphi[1]))*Math.sin(dphi[1]));

        mars.setLayoutX(1190/(1+0.0934*Math.cos(dphi[2]))*Math.cos(dphi[2]));
        mars.setLayoutY(1190/(1+0.0934*Math.cos(dphi[2]))*Math.sin(dphi[2]));
        marsSiatka.setLayoutX(1190/(1+0.0934*Math.cos(dphi[2]))*Math.cos(dphi[2]));
        marsSiatka.setLayoutY(1190/(1+0.0934*Math.cos(dphi[2]))*Math.sin(dphi[2]));

        jowisz.setLayoutX(1585/(1+0.0489*Math.cos(dphi[3]))*Math.cos(dphi[3]));
        jowisz.setLayoutY(1585/(1+0.0489*Math.cos(dphi[3]))*Math.sin(dphi[3]));
        jowiszSiatka.setLayoutX(1585/(1+0.0489*Math.cos(dphi[3]))*Math.cos(dphi[3]));
        jowiszSiatka.setLayoutY(1584/(1+0.0489*Math.cos(dphi[3]))*Math.sin(dphi[3]));
    }

    public void planetSpeedEvaluation()
    {
        dphi[0] += 0.00002;
        dphi[1] += 0.000014;
        dphi[2] += 0.000008;
        dphi[3] += 0.000002;

        vPlanet[0] = ((0.00291196*Math.sin(dphi[0]))/Math.pow(1+0.06772*Math.cos(dphi[0]),2)*Math.cos(dphi[0]) - 0.043/(1+0.06772*Math.cos(dphi[0]))*Math.sin(dphi[0]))/5;
        vPlanet[1] = ((0.00291196*Math.sin(dphi[0]))/Math.pow(1+0.06772*Math.cos(dphi[0]),2)*Math.sin(dphi[0]) + 0.043/(1+0.06772*Math.cos(dphi[0]))*Math.cos(dphi[0]))/5;

        vPlanet[2] = ((0.000941547*Math.sin(dphi[1]))/Math.pow(1+0.0167089*Math.cos(dphi[1]),2)*Math.cos(dphi[1]) - 0.05635/(1+0.0167089*Math.cos(dphi[1]))*Math.sin(dphi[1]))/5;
        vPlanet[3] = ((0.000941547*Math.sin(dphi[1]))/Math.pow(1+0.0167089*Math.cos(dphi[1]),2)*Math.sin(dphi[1]) + 0.05635/(1+0.0167089*Math.cos(dphi[1]))*Math.cos(dphi[1]))/5;

        vPlanet[4] = ((0.00444584*Math.sin(dphi[2]))/Math.pow(1+0.0934*Math.cos(dphi[2]),2)*Math.cos(dphi[2]) - 0.0476/(1+0.0934*Math.cos(dphi[2]))*Math.sin(dphi[2]))/5;
        vPlanet[5] = ((0.00444584*Math.sin(dphi[2]))/Math.pow(1+0.0934*Math.cos(dphi[2]),2)*Math.sin(dphi[2]) + 0.0476/(1+0.0934*Math.cos(dphi[2]))*Math.cos(dphi[2]))/5;

        vPlanet[6] = ((0.000775065*Math.sin(dphi[3]))/Math.pow(1+0.0489*Math.cos(dphi[3]),2)*Math.cos(dphi[3]) - 0.01585/(1+0.0489*Math.cos(dphi[3]))*Math.sin(dphi[3]))/5;
        vPlanet[7] = ((0.000775065*Math.sin(dphi[3]))/Math.pow(1+0.0489*Math.cos(dphi[3]),2)*Math.sin(dphi[3]) + 0.01585/(1+0.0489*Math.cos(dphi[3]))*Math.cos(dphi[3]))/5;
    }

    public void planetGravitionalForce() {
        distance[0] = Math.sqrt(Math.pow(640 - slonce.getLayoutX(), 2) + Math.pow(330 - slonce.getLayoutY(), 2));
        distance[1] = Math.sqrt(Math.pow(640 - wenus.getLayoutX(), 2) + Math.pow(330 - wenus.getLayoutY(), 2));
        distance[2] = Math.sqrt(Math.pow(640 - ziemia.getLayoutX(), 2) + Math.pow(330 - ziemia.getLayoutY(), 2));
        distance[3] = Math.sqrt(Math.pow(640 - mars.getLayoutX(), 2) + Math.pow(330 - mars.getLayoutY(), 2));
        distance[4] = Math.sqrt(Math.pow(640 - jowisz.getLayoutX(), 2) + Math.pow(330 - jowisz.getLayoutY(), 2));

        if(landingSuccess)
        {
            if (distance[0] <= 200)
            {
                gravitationalForce[0] = 5 / Math.pow(distance[0], 2);
                vx += ((slonce.getLayoutX() - 640) / (distance[0])) * gravitationalForce[0];
                vy += ((slonce.getLayoutY() - 330) / (distance[0])) * gravitationalForce[0];
            }
            if (distance[1] <= 180)
            {
                gravitationalForce[1] = 0.225 / Math.pow(distance[1], 2);
                vx += ((wenus.getLayoutX() - 640) / (distance[1])) * gravitationalForce[1];
                vy += ((wenus.getLayoutY() - 330) / (distance[1])) * gravitationalForce[1];
                vLanding = Math.sqrt(Math.pow(vx - vPlanet[0], 2) + Math.pow(vy - vPlanet[1], 2));
            }
            if (distance[2] <= 186)
            {
                gravitationalForce[2] = 0.25 / Math.pow(distance[2], 2);
                vx += ((ziemia.getLayoutX() - 640) / (distance[2])) * gravitationalForce[2];
                vy += ((ziemia.getLayoutY() - 330) / (distance[2])) * gravitationalForce[2];
                vLanding = Math.sqrt(Math.pow(vx - vPlanet[2], 2) + Math.pow(vy - vPlanet[3], 2));
            }
            if (distance[3] <= 96)
            {
                gravitationalForce[3] = 0.095 / Math.pow(distance[3], 2);
                vx += ((mars.getLayoutX() - 640) / (distance[3])) * gravitationalForce[3];
                vy += ((mars.getLayoutY() - 330) / (distance[3])) * gravitationalForce[3];
                vLanding = Math.sqrt(Math.pow(vx - vPlanet[4], 2) + Math.pow(vy - vPlanet[5], 2));
            }
            if (distance[4] <= 300)
            {
                gravitationalForce[4] = 0.59 / Math.pow(distance[4], 2);
                vx += ((jowisz.getLayoutX() - 640) / (distance[4])) * gravitationalForce[4];
                vy += ((jowisz.getLayoutY() - 330) / (distance[4])) * gravitationalForce[4];
                vLanding = Math.sqrt(Math.pow(vx - vPlanet[6], 2) + Math.pow(vy - vPlanet[7], 2));
            }
        }
    }
    public void fuelLevel(double power)
    {
        if(landingSuccess)
            fuel -= power*(SettingsClass.difficultyInt)/(50);
    }

    public void velocityLevel() {
        double w = 0.2/SettingsClass.difficultyInt;
         if(vLanding < w)
         {
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
        MenuController.executor.shutdown();
        FXMLLoader fxmlloader = new FXMLLoader(MenuController.class.getResource("/game/solarjourney/Menu/MenuView.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlloader.load());
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setFullScreen(false);
        stage.show();
    }

    public void rotateLeft()
    {
        rotationSpeed -= 0.02 * ((double) SettingsClass.rotateSensivityValue /100);
    }
    public void rotateRight()
    {
        rotationSpeed += 0.02 * ((double) SettingsClass.rotateSensivityValue /100);
    }



    public void rotation()
    {
        rocket.setRotate(rocket.getRotate() + rotationSpeed);
    }
    public void rocketMotion()
    {
        v = Math.sqrt(Math.pow(vx,2) + Math.pow(vy,2))*1000;

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

        if(landingSuccess)
        {
            if (distance[0] <= 200)
            {
                if (vsPlanet.collisonCheck(rocket.getRotate(), slonce.getLayoutX(), slonce.getLayoutY(), 100))
                {
                    vx = 0;
                    vy = 0;
                    MenuController.executor.shutdown();
                    gameOver.setVisible(true);
                }
            }
            else if (distance[1] <= 180)
            {
                throttleDifferential = 720 / distance[1];
                if (vsPlanet.collisonCheck(rocket.getRotate(), wenus.getLayoutX(), wenus.getLayoutY(), 30))
                {
                    vx = 0;
                    vy = 0;
                    if (f == 1)
                    {
                        MenuController.executor.shutdown();
                        gameOver.setVisible(true);
                    }
                    else
                    {
                        landingSuccess = false;
                        landing(wenus.getRadius(), wenus.getLayoutX(), wenus.getLayoutY());
                        fuel = 100;
                        l = 0;
                        throttleDifferential = 1;
                        SLanding.setVisible(true);
                    }
                }
            }
            else if (distance[2] <= 186)
            {
                throttleDifferential = 744 / distance[2];
                if (vsPlanet.collisonCheck(rocket.getRotate(), ziemia.getLayoutX(), ziemia.getLayoutY(), 31))
                {
                    vx = 0;
                    vy = 0;
                    if (f == 1)
                    {
                        MenuController.executor.shutdown();
                        gameOver.setVisible(true);
                    }
                    else
                    {
                        landingSuccess = false;
                        landing(ziemia.getRadius(), ziemia.getLayoutX(), ziemia.getLayoutY());
                        fuel = 100;
                        l = 1;
                        throttleDifferential = 1;
                        SLanding.setVisible(true);
                    }
                }
            }
            else if (distance[3] <= 96) {
                throttleDifferential = 384 / distance[3];
                if (vsPlanet.collisonCheck(rocket.getRotate(), mars.getLayoutX(), mars.getLayoutY(), 25))
                {
                    vx = 0;
                    vy = 0;
                    if (f == 1)
                    {
                        MenuController.executor.shutdown();
                        gameOver.setVisible(true);
                    }
                    else
                    {
                        landingSuccess = false;
                        landing(mars.getRadius(), mars.getLayoutX(), mars.getLayoutY());
                        fuel = 100;
                        l = 2;
                        throttleDifferential = 1;
                        SLanding.setVisible(true);
                    }
                }
            }
            else if (distance[4] <= 600)
            {
                throttleDifferential = 1200 / distance[4];
                if (vsPlanet.collisonCheck(rocket.getRotate(), jowisz.getLayoutX(), jowisz.getLayoutY(), 50))
                {
                    vx = 0;
                    vy = 0;
                    if (f == 1)
                    {
                        MenuController.executor.shutdown();
                        gameOver.setVisible(true);
                    }
                    else
                    {
                        landingSuccess = false;
                        landing(jowisz.getRadius(), jowisz.getLayoutX(), jowisz.getLayoutY());
                        fuel = 100;
                        l = 3;
                        throttleDifferential = 1;
                        SLanding.setVisible(true);
                    }
                }
            }
            else
                throttleDifferential = 1;
        }
        else
        {
            if(l == 0)
            {
                vx = vPlanet[0];
                vy = vPlanet[1];
                rotationSpeed = 0;
            }
            if(l == 1)
            {
                vx = vPlanet[2];
                vy = vPlanet[3];
                rotationSpeed = 0;
            }
            else if(l == 2)
            {
                vx = vPlanet[4];
                vy = vPlanet[5];
                rotationSpeed = 0;
            }
            else if(l == 3)
            {
                vx = vPlanet[6];
                vy = vPlanet[7];
                rotationSpeed = 0;
            }
        }
    }

    public void throttleUp()
    {
        vx = vx + 0.0005*throttleDifferential*Math.sin(Math.toRadians(rocket.getRotate()))*((double) SettingsClass.throttleSensivityValue /100);
        vy = vy - 0.0005*throttleDifferential*Math.cos(Math.toRadians(rocket.getRotate()))*((double) SettingsClass.throttleSensivityValue /100);
    }
    public void throttleDown()
    {
        vx = vx - 0.00025*throttleDifferential*Math.sin(Math.toRadians(rocket.getRotate()))*((double) SettingsClass.throttleSensivityValue /100);
        vy = vy + 0.00025*throttleDifferential*Math.cos(Math.toRadians(rocket.getRotate()))*((double) SettingsClass.throttleSensivityValue /100);
    }
    /*
    if(f == 2){
        System.out.println("Udalo sie wyladowac");
    }
        else{
        System.out.println("Rakieta sie rozbila");
    }

     */

    public void landing(double r, double x, double y)
    {
        rocket.setRotate(0);
        slonce.setLayoutX(slonce.getLayoutX() + 640 - x);
        slonce.setLayoutY(slonce.getLayoutY() + 345 + r - y);
        wenus.setLayoutX(wenus.getLayoutX() + 640 - x);
        wenus.setLayoutY(wenus.getLayoutY() + 345 + r - y);
        ziemia.setLayoutX(ziemia.getLayoutX() + 640 - x);
        ziemia.setLayoutY(ziemia.getLayoutY() + 345 + r - y);
        mars.setLayoutX(mars.getLayoutX() + 640 - x);
        mars.setLayoutY(mars.getLayoutY() + 345 + r - y);
        jowisz.setLayoutX(jowisz.getLayoutX() + 640 - x);
        jowisz.setLayoutY(jowisz.getLayoutY() + 345 + r - y);

        slonceSiatka.setLayoutX(slonceSiatka.getLayoutX() + 640 - x);
        slonceSiatka.setLayoutY(slonceSiatka.getLayoutY() + 345 + r - y);
        wenusSiatka.setLayoutX(wenusSiatka.getLayoutX() + 640 - x);
        wenusSiatka.setLayoutY(wenusSiatka.getLayoutY() + 345 + r - y);
        ziemiaSiatka.setLayoutX(ziemiaSiatka.getLayoutX() + 640 - x);
        ziemiaSiatka.setLayoutY(ziemiaSiatka.getLayoutY() + 345 + r - y);
        marsSiatka.setLayoutX(marsSiatka.getLayoutX() + 640 - x);
        marsSiatka.setLayoutY(marsSiatka.getLayoutY() + 345 + r - y);
        jowiszSiatka.setLayoutX(jowiszSiatka.getLayoutX() + 640 - x);
        jowiszSiatka.setLayoutY(jowiszSiatka.getLayoutY()+ 345 + r - y);
    }

    public void starting()
    {
        landingSuccess = true;
        SLanding.setVisible(false);
        slonce.setLayoutY(slonce.getLayoutY() + 15);
        wenus.setLayoutY(wenus.getLayoutY() + 15);
        ziemia.setLayoutY(ziemia.getLayoutY() + 15);
        mars.setLayoutY(mars.getLayoutY() + 15);
        jowisz.setLayoutY(jowisz.getLayoutY() + 15);

        slonceSiatka.setLayoutY(slonceSiatka.getLayoutY() + 15);
        wenusSiatka.setLayoutY(wenusSiatka.getLayoutY() + 15);
        ziemiaSiatka.setLayoutY(ziemiaSiatka.getLayoutY() + 15);
        marsSiatka.setLayoutY(marsSiatka.getLayoutY() + 15);
        jowiszSiatka.setLayoutY(jowiszSiatka.getLayoutY()+ 15);

        vx = 0;
        vy = -0.05;
    }


}
