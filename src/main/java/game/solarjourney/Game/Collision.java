package game.solarjourney.Game;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

//Autor: Anna Kodym v
public class Collision
{
    /*
    rocket rocket;
    planet planet;
    public void setRocket(rocket rocket){
        this.rocket = rocket;
    }
    public void setPlanet(planet planet){
        this.planet = planet;
    }
    public void collison(){
        if (rocket.collidesWith(planet)) {
            // Reakcja na kolizję
            System.out.println("Rocket collided with planet!");
        } else {
            System.out.println("Rocket did not collide with planet.");
        }
    }
     */

    private double[] rocketCenter = new double[2];
    private double[] collisonPoints = new double[8];
    private double[] collisonDistance = new double[4];

    public Collision() {}
    public boolean collisonCheck(double rotation, double lx, double ly, double r)
    {
        //srodek rakiety 640,330
        //wymiary rakiety 16,30
        //pierwszy punkt X,Y
        collisonPoints[0] = 640 + 8*Math.sin(Math.toRadians(rotation));
        collisonPoints[1] = 330 - 15*Math.cos(Math.toRadians(rotation));
        //drugi punkt X,Y
        collisonPoints[2] = 640 + 8*Math.cos(Math.toRadians(rotation));
        collisonPoints[3] = 330 + 15*Math.sin(Math.toRadians(rotation));
        //trzeci punkt X,Y
        collisonPoints[4] = 640 - 8*Math.sin(Math.toRadians(rotation));
        collisonPoints[5] = 330 + 15*Math.cos(Math.toRadians(rotation));
        //czwarty punkt X,Y
        collisonPoints[6] = 640 - 8*Math.cos(Math.toRadians(rotation));
        collisonPoints[7] = 330 - 15*Math.sin(Math.toRadians(rotation));

        collisonDistance[0] = Math.sqrt(Math.pow(lx - collisonPoints[0],2) + Math.pow(ly - collisonPoints[1],2));
        collisonDistance[1] = Math.sqrt(Math.pow(lx - collisonPoints[2],2) + Math.pow(ly - collisonPoints[3],2));
        collisonDistance[2] = Math.sqrt(Math.pow(lx - collisonPoints[4],2) + Math.pow(ly - collisonPoints[5],2));
        collisonDistance[3] = Math.sqrt(Math.pow(lx - collisonPoints[6],2) + Math.pow(ly - collisonPoints[7],2));

        if(collisonDistance[0] <= r)
        {
            return true;
        }
        if(collisonDistance[1] <= r)
        {
            return true;
        }
        if(collisonDistance[2] <= r)
        {
            return true;
        }
        if(collisonDistance[3] <= r)
        {
            return true;
        }
        return false;
    }

}
