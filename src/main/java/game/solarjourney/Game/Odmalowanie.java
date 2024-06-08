package game.solarjourney.Game;

import javafx.application.Platform;

public class Odmalowanie implements Runnable {
    private GameController controller;

    public Odmalowanie(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        Platform.runLater(() -> {
            controller.setRB();
            controller.setFuelLevel();
            controller.setVelocity();
        });
    }
}