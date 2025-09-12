package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import javafx.scene.image.Image;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login_cadastro.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),360,800);
        scene.getStylesheets().add(Objects.requireNonNull(HelloApplication.class.getResource("/CSS/styleApp.css")).toExternalForm());
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/incone.png")));
        stage.setTitle("ASA Application");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }
}
