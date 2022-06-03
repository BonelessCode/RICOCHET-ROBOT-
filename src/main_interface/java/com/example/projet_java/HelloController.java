package com.example.projet_java;

import com.example.projet_java.components.Cellule;
import com.example.projet_java.entities.DestinationJeton;
import com.example.projet_java.entities.Robot;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.example.projet_java.jeu.Jeu;


import java.util.*;


import static java.lang.Math.abs;


public class HelloController {
    private static final int MAX_COUPS = 2147483646;
    @FXML
    int nombreJoueurs=1;
    public static final int WIDTH = 16;

    public static final int SCREEN_SIZE = 760;


    Text texteTimer = new Text("30");

    GridPane root;

    List<TextField> listeCoupsJoueursTextField;
    List<Label> listePointsJoueursText;



    Label labelJoueurs;

    Robot robotSelected;

    ImageView imageSelectionnee;



    Image pionDefaut = new Image(getClass().getResourceAsStream("/img/pion_bleu.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);


    Image caseVide = new Image(getClass().getResourceAsStream("/img/case_vide.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);
    Image caseMur1 = new Image(getClass().getResourceAsStream("/img/case_mur1.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);
    Image caseMur2 = new Image(getClass().getResourceAsStream("/img/case_mur2.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);
    Image caseMur3 = new Image(getClass().getResourceAsStream("/img/case_mur3.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);
    Image caseMur4 = new Image(getClass().getResourceAsStream("/img/case_mur4.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);


    Image caseMur12 = new Image(getClass().getResourceAsStream("/img/case_mur12.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);

    Image caseMur14 = new Image(getClass().getResourceAsStream("/img/case_mur14.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);

    Image caseMur23 = new Image(getClass().getResourceAsStream("/img/case_mur23.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);

    Image caseMur34 = new Image(getClass().getResourceAsStream("/img/case_mur34.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);
    Image caseMur1234 = new Image(getClass().getResourceAsStream("/img/case_mur1234.png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false);

    ImageView imageJetonTirage;
    boolean finTimer;


    @FXML
    private Label nombreJoueur;
    private int joueurActuel;
    private List<ImageView> listeImagesRobots = new ArrayList<>();
    private Button boutonReset = new Button("Reset");
    private Button boutonNext = new Button("Next");
    private ArrayList<Integer> listeCoupsJoueursRestants;

    @FXML
    protected void onPlayButtonClick(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();


        Stage stage = new Stage();

        root = new GridPane();
        root.setHgap(1);
        root.setVgap(1);


        Cellule[][] plateau = Jeu.plateau;

        listeCoupsJoueursTextField = new ArrayList<>();
        listePointsJoueursText = new ArrayList<>();

        resetListeCoups();
        resetListeCoupsMini();
        Jeu.listePointsJoueurs = new ArrayList<>(Collections.nCopies(nombreJoueurs, 0));


        initialisationMursGraphique(plateau);

        afficherJeton();

        afficherTextInputJoueurs();

        afficherRobots();

        afficherJetonsPlateau();

        timer();

        Scene scene = new Scene(root, SCREEN_SIZE, SCREEN_SIZE);

        stage.setTitle("Ricochet Robots!");
        scene.setFill(Color.web("#006AF9"));
        stage.setScene(scene);

        stage.show();


        deplacementPosition(scene);
    }


    private void resetListeCoups() {
        Jeu.listeCoupsJoueurs = new ArrayList<>(Collections.nCopies(nombreJoueurs, MAX_COUPS));

    }

    private void deplacementPosition(Scene scene) {
        scene.setOnKeyPressed(keyEvent -> {

            System.out.println(finTimer);
            System.out.println(robotSelected);

            if (robotSelected != null && finTimer) {

                System.out.println("done");
                int[] nouvellePosition = {robotSelected.getPositionX(),robotSelected.getPositionY()};

                switch (keyEvent.getCode()) {
                    case Z:
                        nouvellePosition = Jeu.deplacement(robotSelected,2);
                        Jeu.nbrCoup +=1;
                        System.out.println("Nombre de coup :" +Jeu.nbrCoup);
                        break;

                    case S:
                        nouvellePosition = Jeu.deplacement(robotSelected,4);
                        Jeu.nbrCoup +=1;
                        System.out.println("Nombre de coup :" +Jeu.nbrCoup);
                        break;

                    case Q:
                        nouvellePosition = Jeu.deplacement(robotSelected,1);
                        Jeu.nbrCoup +=1;
                        System.out.println("Nombre de coup :" +Jeu.nbrCoup);
                        break;

                    case D:
                        nouvellePosition = Jeu.deplacement(robotSelected,3);
                        Jeu.nbrCoup +=1;
                        System.out.println("Nombre de coup :" +Jeu.nbrCoup);
                        break;


                    case ESCAPE:
                        // Réinitialise les positions des robots
                        Jeu.nbrCoup=0;
                        for (Robot robot : Jeu.robots){
                            robot.setPositionX(robot.getPositionBaseX());
                            robot.setPositionY(robot.getPositionBaseY());
                        }
                        break;
                }

                // TODO : corriger le problème car va ajouter déplacement même si on appuye pas sur les flèches

                System.out.println("Position actuelle : "+robotSelected.getPositionX()+" "+robotSelected.getPositionY());
                System.out.println("Nouvelle position : "+nouvellePosition[0]+ " "+ nouvellePosition[1]);


                animate(imageSelectionnee,robotSelected.getPositionX(),robotSelected.getPositionY(),nouvellePosition[0],nouvellePosition[1]);
                robotSelected.setPositionX(nouvellePosition[0]);
                robotSelected.setPositionY(nouvellePosition[1]);


                verifierVictoire();
            }
        });
    }

    private void verifierVictoire() {
        if(Jeu.verifJeton(robotSelected)==1){
            System.out.println("Nombre de coups i.e : "+Jeu.nbrCoup);
            System.out.println("Jeu.listeCoupsJoueurs : "+Jeu.listeCoupsJoueurs);
            System.out.println("joueurActuel : "+joueurActuel);

            System.out.println("Coups prévu : "+Jeu.listeCoupsJoueurs.get(joueurActuel));

//          Si le joueur a tapé le bon nombre de coup
            if(Jeu.nbrCoup==Jeu.listeCoupsJoueurs.get(joueurActuel)){
                Jeu.listePointsJoueurs.set(joueurActuel,Jeu.listePointsJoueurs.get(joueurActuel)+1);

                for (Robot robot: Jeu.robots) {
                    robot.resetPositionBase();
                }
                passagePhaseReflexion();

            }
        }
    }

    private void resetListeCoupsMini() {
        listeCoupsJoueursRestants = new ArrayList<>(Collections.nCopies(nombreJoueurs, MAX_COUPS));
    }


    private void resetJetonEtTimer() {
        resetListeCoups();
        resetListeCoupsMini();

        Jeu.jeton = Jeu.choisirJeton();

        Image image = new Image(getClass().getResourceAsStream("/img/"+ Jeu.jeton.getPath() + ".png"), (SCREEN_SIZE / 17), (SCREEN_SIZE / 17), false, false);
        imageJetonTirage.setImage(image);

        finTimer = false;
        timer();
    }


    private void afficherJetonsPlateau() {
        ImageView image;
        // Ajouter Jetons sur le plateau
        for (DestinationJeton destinationJeton : Jeu.destinationJetons) {

            image = new ImageView(new Image(getClass().getResourceAsStream("/img/"+destinationJeton.getPath()+".png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false)); // TODO : CHANGER PAR PATH

            root.add(image,destinationJeton.getPosx(),destinationJeton.getPosy());
        }
    }

    private void afficherRobots() {
        // Ajouter robots sur le plateau
        for (Robot robot : Jeu.robots) {

            ImageView imageRobots = new ImageView(new Image(getClass().getResourceAsStream("/img/"+robot.getPath()+".png"), SCREEN_SIZE / 17, SCREEN_SIZE / 17, false, false));

            imageRobots.setOnMouseClicked(mouseEvent -> {
                robotSelected = robot;
                imageSelectionnee = imageRobots;

            });
            root.add(imageRobots,robot.getPositionX(),robot.getPositionY());

            listeImagesRobots.add(imageRobots);
        }
    }

    private void afficherTextInputJoueurs() {
        ImageView image;
        for(int h = 0; h<nombreJoueurs; h++){
            image = new ImageView(caseMur1234);
            root.add(image,16+h/16,h%16);

            TextField text = new TextField();
            text.setMaxWidth(SCREEN_SIZE / 17);
            text.setPadding(new Insets(0, 0, 0, 20));

            root.add(text,16+h/16,h%16);
            listeCoupsJoueursTextField.add(text);

            Text number = new Text(""+(h+1));
            root.add(number,16+h/16,h%16);
        }
    }

    private void supprimerTextPointsJoueurs() {
        for (Label text : listePointsJoueursText) {
            root.getChildren().remove(text);
        }
    }

    private void afficherTextPointsJoueurs() {
        for(int h = 0; h<nombreJoueurs; h++){
            Label text = new Label(""+Jeu.listePointsJoueurs.get(h));
            text.setMaxWidth(SCREEN_SIZE / 17);
            text.setStyle("-fx-text-fill: white;");
            text.setPadding(new Insets(0, 0, 0, 20));

            root.add(text,16+h/16,h%16);
            listePointsJoueursText.add(text);
        }
    }


    private void supprimerTextInputJoueurs() {
        for (TextField text : listeCoupsJoueursTextField) {
            root.getChildren().remove(text);
        }

        listeCoupsJoueursTextField = new ArrayList<>();
    }



    private void afficherJeton() {
        Image jeton = new Image(getClass().getResourceAsStream("/img/"+ Jeu.jeton.getPath() + ".png"), (SCREEN_SIZE / 17), (SCREEN_SIZE / 17), false, false);
        imageJetonTirage = new ImageView(jeton);
        root.add(imageJetonTirage,0 , 17);
    }

    private void initialisationMursGraphique(Cellule[][] plateau) {
        Cellule celluleActuelle;
        ImageView image;

        root.add(texteTimer, 1, 17);

        for (int k = 0; k < WIDTH; k++) {
            for (int j = 0; j < WIDTH; j++) {

                celluleActuelle = plateau[j][k];

                if (!celluleActuelle.isMurBas() && !celluleActuelle.isMurHaut() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurGauche()) {
                    image = new ImageView(caseVide);
                } else if (celluleActuelle.isMurBas() && !celluleActuelle.isMurHaut() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurGauche()) {
                    image = new ImageView(caseMur4);
                } else if (celluleActuelle.isMurHaut() && !celluleActuelle.isMurBas() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurGauche()) {
                    image = new ImageView(caseMur2);
                } else if (celluleActuelle.isMurGauche() && !celluleActuelle.isMurBas() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurHaut()) {
                    image = new ImageView(caseMur1);
                } else if (celluleActuelle.isMurDroit() && !celluleActuelle.isMurBas() && !celluleActuelle.isMurHaut() && !celluleActuelle.isMurGauche()) {
                    image = new ImageView(caseMur3);
                } else if (celluleActuelle.isMurGauche() && celluleActuelle.isMurHaut() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurBas()) {
                    image = new ImageView(caseMur12);
                } else if (celluleActuelle.isMurGauche() && celluleActuelle.isMurBas() && !celluleActuelle.isMurDroit() && !celluleActuelle.isMurHaut()) {
                    image = new ImageView(caseMur14);
                } else if (celluleActuelle.isMurHaut() && celluleActuelle.isMurDroit() && !celluleActuelle.isMurBas() && !celluleActuelle.isMurGauche()) {
                    image = new ImageView(caseMur23);
                } else if (celluleActuelle.isMurDroit() && celluleActuelle.isMurBas() && !celluleActuelle.isMurHaut() && !celluleActuelle.isMurGauche()) {
                    image = new ImageView(caseMur34);
                } else {
                    image = new ImageView(caseMur1234);
                }
                root.add(image, k, j);
            }
        }


    }


    private void timer() {


        Timer t = new Timer( );
        t.scheduleAtFixedRate(new TimerTask() {
            int time = 30;

            @Override
            public void run() {
                time--;
                texteTimer.setText(""+time);
                if(time==0){

                    for(int x=0;x<Jeu.listeCoupsJoueurs.size();x++){
                        Jeu.listeCoupsJoueurs.set(x,listeCoupsJoueursTextField.get(x).getText().replaceAll("[^0-9]", "") == "" ? MAX_COUPS : Integer.parseInt(listeCoupsJoueursTextField.get(x).getText().replaceAll("[^0-9]", "")));
                        listeCoupsJoueursRestants = new ArrayList<>(Jeu.listeCoupsJoueurs);
                    }


                    System.out.println("Jeu.listeCoupsJoueurs : "+Jeu.listeCoupsJoueurs);


                    if(Collections.min(Jeu.listeCoupsJoueurs).intValue()!=MAX_COUPS){
                        joueurActuel = Jeu.listeCoupsJoueurs.indexOf(Collections.min(Jeu.listeCoupsJoueurs));
                        texteTimer.setText("J"+(joueurActuel+1));
                        finTimer = true;
                    }



                    Platform.runLater(() -> {
                        if(Collections.min(Jeu.listeCoupsJoueurs)!=MAX_COUPS) {
                            passagePhaseGameplay();
                        }
                        else{
                            resetJetonEtTimer();
                        }
                    });
                    cancel();
                }
            }
        }, 0,1000);
    }

    private void passagePhaseGameplay() {
        Jeu.nbrCoup = 0;
        supprimerTextInputJoueurs();
        afficherTextPointsJoueurs();
        afficherBoutons();
    }

    private void afficherBoutons() {
        root.add(boutonNext,14,16);
        root.add(boutonReset,15,16);

        boutonNext.setOnMouseClicked(mouseEvent -> {
            listeCoupsJoueursRestants.remove(Collections.min(listeCoupsJoueursRestants));
            System.out.println("listeCoupsJoueursRestants : "+ listeCoupsJoueursRestants);

            if(!listeCoupsJoueursRestants.isEmpty()){
                if(Collections.min(listeCoupsJoueursRestants)!=MAX_COUPS){
                    joueurActuel =Jeu.listeCoupsJoueurs.lastIndexOf((Collections.min(listeCoupsJoueursRestants)));
                    texteTimer.setText("J"+(joueurActuel+1));
                }
                else{
                    passagePhaseReflexion();
                }
            }

            else{
                passagePhaseReflexion();
            }
        });

        boutonReset.setOnMouseClicked(mouseEvent -> {

            for (ImageView imageView:listeImagesRobots) {
                root.getChildren().remove(imageView);
            }
            listeImagesRobots = new ArrayList<>();

            for (Robot robot: Jeu.robots) {
                robot.setPositionX(robot.getPositionBaseX());
                robot.setPositionY(robot.getPositionBaseY());

            }
            afficherRobots();
            Jeu.nbrCoup=0;
        });
    }

    private void passagePhaseReflexion() {

        supprimerTextPointsJoueurs();
        afficherTextInputJoueurs();
        supprimerBoutons();

        resetJetonEtTimer();
    }

    private void supprimerBoutons() {
        root.getChildren().remove(boutonNext);
        root.getChildren().remove(boutonReset);
    }


    @FXML
    protected void onAddButtonClick(){
        nombreJoueurs++;
        nombreJoueur.setText("Nombre de joueurs : " +nombreJoueurs);
    }

    @FXML
    protected void onDecreaseButtonClick(){
        nombreJoueurs = nombreJoueurs>1 ? nombreJoueurs-1 : 1;
        nombreJoueur.setText("Nombre de joueurs : " +nombreJoueurs);
    }

    private void animate(ImageView entite ,int posxDebut,int posyDebut,int posx, int posy) {

//        double xDebut = entite.getLayoutX(); double yDebut = entite.getLayoutY(); //measure new location
//
//        root.getChildren().remove(entite);
//
//        root.add(entite, abs(posx), abs(posy));
//        root.layout();
//
//        double x = entite.getLayoutX();
//        double y = entite.getLayoutY();
//
//
//
//
//        root.getChildren().remove(entite);
//        root.add(entite, posxDebut, posyDebut);
//        entite.setVisible(true);
//
//
//        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1),entite);
//
//        if (posx == posxDebut){
//            translateTransition.setToY(posy-posyDebut>0 ? y : -y);
//        }
//        else if(posy == posyDebut){
//            translateTransition.setToX(posx-posxDebut>0 ?  x : -x);
//        }
//
//
//
//        translateTransition.play();
//
//        translateTransition.setOnFinished(e->{
//            root.getChildren().remove(entite);
//            entite.setTranslateX(0);
//            entite.setTranslateY(0);
//            root.add(entite, posx, posy);
//        });

        root.getChildren().remove(entite);

        root.add(entite, posx, posy);
    }

}
