package com.example.projet_java;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    public static final int TILE_SIZE = 100;
    public static final int WIDTH = 16;
    public static final int SCREEN_SIZE = 860;

    GridPane root;
    ImageView player;




    @Override
    public void start(Stage stage) throws IOException {
        Parent root = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml")).load();
        stage.setTitle("Ricochet Robots!");

        stage.setScene(new Scene(root, SCREEN_SIZE, SCREEN_SIZE));
        stage.show();
    }




    public static void main(String[] args) {
        launch();
    }
}