package game.solarjourney.Game;

import javafx.scene.shape.Circle;

//autor: Anna Kodym v
public class planet {
    public int planetid = 0; //do ustawiania planety końcowej
    public Circle planet;
    public int radius;
    public double x,y;
    public void setPlanet(Circle planet){
        this.planet = planet;
    }
    public void setPlanetid(){
        planetid = 1;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public int getRadius(){
        return this.radius;
    }
}
