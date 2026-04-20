package com.springmvc.app.fefsysteminformation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/ec/edu/upse/FEF/vista/fef-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 840, 620);
        stage.setTitle("Gestion FEF - Equipos de Futbol");
        stage.setScene(scene);
        stage.show();
    }
}
