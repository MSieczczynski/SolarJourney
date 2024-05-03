module game.solarjourney {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    exports game.solarjourney.Settings;
    exports game.solarjourney.Menu;
    exports  game.solarjourney.Game;
    opens game.solarjourney.Menu to javafx.fxml;
    opens game.solarjourney.Settings to javafx.fxml;
    opens game.solarjourney.Game to javafx.fxml;
}