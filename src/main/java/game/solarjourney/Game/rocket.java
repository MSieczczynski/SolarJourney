package game.solarjourney.Game;

import javafx.scene.shape.Circle;

//Autor: Anna Kodym
public class rocket {
    public int radius = 10;
    public double x,y;

    public boolean collidesWith(planet planet) {
        double distance = Math.sqrt(Math.pow(x - planet.getX(), 2) + Math.pow(y - planet.getY(), 2));
        return distance <= radius + planet.getRadius();
    }
}
//control check d
