package game.solarjourney.Game;

import javafx.application.Platform;

public class PlanetControl implements Runnable
{
    private GameController controller;

    public PlanetControl(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        Platform.runLater(() -> {
            controller.planetSpeedEvaluation();
            controller.planetPosition();
        });
    }
}
