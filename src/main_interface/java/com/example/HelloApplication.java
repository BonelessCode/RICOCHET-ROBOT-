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
import jeu.Jeu;

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


        Image player = new Image(getClass().getResourceAsStream("/img/pion_bleu.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);


        Image caseVide = new Image(getClass().getResourceAsStream("/img/case_vide.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
        Image caseMur1 = new Image(getClass().getResourceAsStream("/img/case_mur1.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
        Image caseMur2 = new Image(getClass().getResourceAsStream("/img/case_mur2.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
        Image caseMur3 = new Image(getClass().getResourceAsStream("/img/case_mur3.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
        Image caseMur4 = new Image(getClass().getResourceAsStream("/img/case_mur4.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);


        Image caseMur12 = new Image(getClass().getResourceAsStream("/img/case_mur12.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);

        Image caseMur14 = new Image(getClass().getResourceAsStream("/img/case_mur14.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);

        Image caseMur23 = new Image(getClass().getResourceAsStream("/img/case_mur23.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);

        Image caseMur34 = new Image(getClass().getResourceAsStream("/img/case_mur34.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
        Image caseMur1234 = new Image(getClass().getResourceAsStream("/img/case_mur1234.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);

//        Image caseMur123 = new Image(getClass().getResourceAsStream("/img/case_mur_123.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//        Image caseMur124 = new Image(getClass().getResourceAsStream("/img/case_mur_124.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//        Image caseMur134 = new Image(getClass().getResourceAsStream("/img/case_mur_134.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//
//        Image caseMur234 = new Image(getClass().getResourceAsStream("/img/case_mur_234.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);
//
//
//        Image caseMur1234 = new Image(getClass().getResourceAsStream("/img/case_mur_1234.png"),SCREEN_SIZE/16,SCREEN_SIZE/16,false,false);

        Cellule[][] plateau = Jeu.plateau;
        ImageView image;
        Cellule celluleActuelle;



        for (int k=0;k<WIDTH;k++){
            for (int j=0;j<WIDTH;j++) {

                celluleActuelle = plateau[j][k];

                if(!celluleActuelle.isMurBas() && !celluleActuelle.isMurHaut() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurGauche() ){
                    image = new ImageView(caseVide);
                }

                else if(celluleActuelle.isMurBas() && !celluleActuelle.isMurHaut() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurGauche() ){
                    image = new ImageView(caseMur4);
                }
                else if (celluleActuelle.isMurHaut() && !celluleActuelle.isMurBas() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurGauche()){
                    image =new ImageView(caseMur2);
                }
                else if (celluleActuelle.isMurGauche() && !celluleActuelle.isMurBas() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurHaut()){
                    image =new ImageView(caseMur1);
                }
                else if (celluleActuelle.isMurDroit() && !celluleActuelle.isMurBas() && !celluleActuelle.isMurHaut() && !celluleActuelle.isMurGauche()){
                    image =new ImageView(caseMur3);
                }
                else if(celluleActuelle.isMurGauche() && celluleActuelle.isMurHaut() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurBas()){
                    image = new ImageView(caseMur12);
                }

                else if(celluleActuelle.isMurGauche() && celluleActuelle.isMurBas() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurHaut()){
                    image = new ImageView(caseMur14);
                }
                else if(celluleActuelle.isMurHaut() && celluleActuelle.isMurDroit() && !celluleActuelle.isMurBas() && !celluleActuelle.isMurGauche()){
                    image = new ImageView(caseMur23);
                }

                else if(celluleActuelle.isMurDroit() && celluleActuelle.isMurBas() && !celluleActuelle.isMurHaut() && !celluleActuelle.isMurGauche()){
                    image = new ImageView(caseMur34);
                }
                else{
                    image = new ImageView(caseMur1234);
                }



                root.add(image, k, j);
            }
        }

        this.player = new ImageView(player);
        root.add(this.player, 0, 0);

        animate(0,0,2,0);








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

    private void animate(int posxDebut,int posyDebut,int posx, int posy) {

        //remove unit, make it invisible, and add it to desired location
        root.getChildren().remove(player);
        player.setVisible(false);
        root.add(player, posx, posy);
        root.layout(); //apply top down layout pass
        //get x y of new location
        double x = player.getLayoutX(); double y = player.getLayoutY(); //measure new location

        //return to original location
        root.getChildren().remove(player);
        root.add(player, posxDebut, posyDebut);
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