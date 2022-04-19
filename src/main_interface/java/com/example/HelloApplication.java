package com.example;

import components.Cellule;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {

    public static final int TILE_SIZE = 100;
    public static final int WIDTH = 16;
    public static final int SCREEN_SIZE = 860;

    GridPane root;
    ImageView player;

    @Override
    public void start(Stage stage) throws IOException {
        root = new GridPane();

        root.setHgap(1);
        root.setVgap(1);


        Image player = new Image(getClass().getResourceAsStream("/img/case_mur_1.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);


        Image caseVide = new Image(getClass().getResourceAsStream("/img/case_vide.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//        Image caseMur1 = new Image(getClass().getResourceAsStream("/img/case_mur_1.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//        Image caseMur2 = new Image(getClass().getResourceAsStream("/img/case_mur_2.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//        Image caseMur3 = new Image(getClass().getResourceAsStream("/img/case_mur_3.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//        Image caseMur4 = new Image(getClass().getResourceAsStream("/img/case_mur_4.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//
//
//        Image caseMur12 = new Image(getClass().getResourceAsStream("/img/case_mur_12.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//        Image caseMur13 = new Image(getClass().getResourceAsStream("/img/case_mur_13.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//        Image caseMur14 = new Image(getClass().getResourceAsStream("/img/case_mur_14.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//
//        Image caseMur23 = new Image(getClass().getResourceAsStream("/img/case_mur_23.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//        Image caseMur24 = new Image(getClass().getResourceAsStream("/img/case_mur_24.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//
//        Image caseMur34 = new Image(getClass().getResourceAsStream("/img/case_mur_34.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//
//
//        Image caseMur123 = new Image(getClass().getResourceAsStream("/img/case_mur_123.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//        Image caseMur124 = new Image(getClass().getResourceAsStream("/img/case_mur_124.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//        Image caseMur134 = new Image(getClass().getResourceAsStream("/img/case_mur_134.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//
//        Image caseMur234 = new Image(getClass().getResourceAsStream("/img/case_mur_234.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//
//
//        Image caseMur1234 = new Image(getClass().getResourceAsStream("/img/case_mur_1234.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);


        for (int k=0;k<WIDTH;k++){
            for (int j=0;j<WIDTH;j++) {

                ImageView image = new ImageView(caseVide);
                root.add(image, k, j);
            }
        }

        this.player = new ImageView(player);
        root.add(this.player, 0, 0);

        animate(15,15);




//        image.setFitHeight(50);
//        image.setFitWidth(50);



//        button.setOnMouseClicked((event) -> {
//            System.out.printf("X coordinate:%f%n", event.getX());
//            System.out.printf("Y coordinate:%f%n", event.getY());
//            button.setText("Boo");
//        });


        Scene scene = new Scene(root, SCREEN_SIZE, SCREEN_SIZE);
        stage.setTitle("Ricochet Robots!");
        scene.setFill(Color.web("#006AF9"));
        stage.setScene(scene);
        stage.show();
    }

    private void animate(int posx, int posy) {

        //remove unit, make it invisible, and add it to desired location
        root.getChildren().remove(player);
        player.setVisible(false);
        root.add(player, posx, posy);
        root.layout(); //apply top down layout pass
        //get x y of new location
        double x = player.getLayoutX(); double y = player.getLayoutY(); //measure new location

        //return to original location
        root.getChildren().remove(player);
        root.add(player, 0, 0);
        player.setVisible(true);

        //apply translation to x,y of new location
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(3));
        translateTransition.setToX(x);
        translateTransition.setToY(y);
        translateTransition.setNode(player);
        translateTransition.play();
        //when translation is finished remove from original location
        //add to desired location and set translation to 0
        translateTransition.setOnFinished(e->{
            root.getChildren().remove(player);
            player.setTranslateX(0);player.setTranslateY(0);
            root.add(player, posx, posy);
        });
    }

    public static void main(String[] args) {
        launch();
    }
}