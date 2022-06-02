package com.example.projet_java;

import com.example.projet_java.components.Cellule;
import com.example.projet_java.entities.JetonTirage;
import com.example.projet_java.entities.Robot;
import com.example.projet_java.jeu.Jeu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.projet_java.jeu.Jeu.*;

public class JeuTests {
    @Test
    public void deplacementHautTest(){
        Jeu.genererPlateau();
        Jeu.genererRobots();
        Robot robot = new Robot(15,15,"v","");

        int[] posExpected = {15,9};


        int[] posExperimentale = Jeu.deplacement(robot,2);

        int positionXRobot = Robot.getPositionBaseX();
        int positionYRobot = Robot.getPositionBaseY();
        boolean vrai = false;

        if(0<= positionXRobot || positionXRobot <=17 || 0 <= positionYRobot || positionYRobot <= 17){
            vrai = true;
        }
        Assertions.assertTrue(vrai);
        Assertions.assertArrayEquals(posExperimentale,posExpected);

    }
    @Test
    public void jetonsTest(){
        Jeu.genererPlateau();
        Jeu.genererRobots();
        Jeu.destinationJeton();

        Jeu.jeton = new JetonTirage(1,"");
        Robot robot = new Robot(11,6,"j","");



        Assertions.assertTrue(Jeu.verifJeton(robot)==1);
    }

    @Test
    public void deplacementBasTest(){
        Jeu.genererPlateau();
        Jeu.genererRobots();
        Robot robot = new Robot(0,0,"v","");

        int[] posExpected = {0,3};


        int[] posExperimentale = Jeu.deplacement(robot,4);

        Assertions.assertArrayEquals(posExperimentale,posExpected);
    }

    @Test

    public void choisirJetonTest() throws Exception{
        genererJetonTirage();
        destinationJeton();
        JetonTirage jetonTest = choisirJeton();
        // String str = jeton.getClass().getSimpleName();

        int idDuJeton  = jetonTest.getId();
        int[] nombre = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
        boolean condition = false;
        for(int i =0; i != nombre.length-1; i++){
            if(idDuJeton == nombre[i]){
                condition = true;
            }
        }

        List<String> paths = List.of("JauneCercle",
                "JauneTriangle",
                "JauneCarre",
                "JauneHexa",
                "BleuCercle",
                "BleuTriangle",
                "BleuCarre",
                "BleuHexa",
                "VertCercle",
                "VertTriangle",
                "VertCarre",
                "VertHexa",
                "RougeCercle",
                "RougeTriangle",
                "RougeCarre",
                "RougeHexa");

        boolean conditionPath = false;
        boolean conditionPath1 = false;

        for(int longueurTableau = 0; longueurTableau < paths.size(); longueurTableau++){
            if (jetonTest.getPath() == paths.get(longueurTableau)){
                conditionPath = true;
            }
        }

        for(int longueurTableau1 = 0; longueurTableau1 < paths.size(); longueurTableau1++){
            if (destinationJetons.get(longueurTableau1).getPath() == paths.get(longueurTableau1)){
                conditionPath1 = true;
            }
        }

        Assertions.assertTrue(conditionPath);
        Assertions.assertTrue(conditionPath1);
        Assertions.assertTrue(condition);


    }

    public void deplacementGaucheTest(){
        Jeu.genererPlateau();
        Jeu.genererRobots();
        Robot robot = new Robot(15,7,"v","");

        int[] posExpected = {9,7};

        int[] posExperimentale = Jeu.deplacement(robot,1);

        Assertions.assertArrayEquals(posExperimentale,posExpected);
    }


    @Test
    public void deplacementDroitTest(){
        Jeu.genererPlateau();
        Jeu.genererRobots();
        Robot robot = new Robot(10,2,"v","");

        int[] posExpected = {15,2};

        int[] posExperimentale = Jeu.deplacement(robot,3);

        Assertions.assertArrayEquals(posExperimentale,posExpected);
    }




}
