package game.solarjourney.Game;

import javafx.application.Platform;

public class Aktualizacja implements Runnable {
    private GameController controller;

    public Aktualizacja(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        Platform.runLater(() -> {
            //controller.goUp();
            controller.rotation();
            controller.rocketMotion();
            controller.velocityLevel();
            controller.planetGravitionalForce();
        });
    }
}
