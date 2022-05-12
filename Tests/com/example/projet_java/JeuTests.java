package com.example.projet_java;

import com.example.projet_java.components.Cellule;
import com.example.projet_java.entities.Robot;
import com.example.projet_java.jeu.Jeu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JeuTests {
    @Test
    public void deplacementTest(){
        Jeu.genererPlateau();
        Jeu.genererRobots();
        Robot robot = new Robot(15,15,"v","");

        int[] posExpected = {15,9};


        int[] posExperimentale = Jeu.deplacement(robot,2);


        Assertions.assertArrayEquals(posExperimentale,posExpected);
    }
}
