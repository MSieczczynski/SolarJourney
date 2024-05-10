package game.solarjourney.Game;

public class rocket {
    public int radius;
    public double x,y;
    public boolean collidesWith(planet planet) {
        double distance = Math.sqrt(Math.pow(x - planet.getX(), 2) + Math.pow(y - planet.getY(), 2));
        return distance <= radius + planet.getRadius();
    }
}
