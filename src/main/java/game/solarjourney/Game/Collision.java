package game.solarjourney.Game;
//Autor: Anna Kodym v
public class Collision {
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
}
