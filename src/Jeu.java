import components.Cellule;
import entities.Joueur;

public class Jeu {

    Input input;
    Joueur joueur1;
    Joueur joueur2;
    int taillePlateau = 16;

    Cellule[][] plateau;

    public void genererPlateau(){
        plateau = new Cellule[taillePlateau][taillePlateau];

//      MURS CONTOUR
        for (int i=0;i<taillePlateau;i++){
            int dernierePosition = taillePlateau-1;



            plateau[0][i].setMurHaut(true);
            plateau[dernierePosition][i].setMurBas(true);

            plateau[i][0].setMurGauche(true);
            plateau[i][dernierePosition].setMurGauche(true);
        }

//      MURS PRES DU CONTOUR

        //        Murs du haut
        plateau[0][2].setMurDroit(true);
        plateau[0][11].setMurDroit(true);

        //        Murs à droite
        plateau[3][taillePlateau].setMurBas(true);
        plateau[8][taillePlateau].setMurBas(true);

        //        Murs en bas
        plateau[taillePlateau][4].setMurDroit(true);
        plateau[taillePlateau][13].setMurDroit(true);

        //        Murs à gauche
        plateau[3][0].setMurBas(true);
        plateau[11][0].setMurBas(true);

        //        Murs RICHARD

        plateau[1][5].setMurBas(true);
        plateau[1][5].setMurGauche(true);

        plateau[1][13].setMurHaut(true);
        plateau[1][13].setMurGauche(true);

        plateau[2][7].setMurBas(true);
        plateau[2][7].setMurDroit(true);

        plateau[1][9].setMurBas(true);
        plateau[1][9].setMurDroit(true);

        plateau[4][3].setMurBas(true);
        plateau[4][3].setMurDroit(true);

        plateau[5][6].setMurHaut(true);
        plateau[5][6].setMurGauche(true);

        plateau[5][14].setMurBas(true);
        plateau[5][14].setMurGauche(true);

        plateau[6][1].setMurHaut(true);
        plateau[6][1].setMurDroit(true);

        plateau[6][11].setMurHaut(true);
        plateau[6][11].setMurDroit(true);

        //      CELLULES CENTRALES

        plateau[7][7].setMurHaut(true);
        plateau[7][7].setMurDroit(true);
        plateau[7][7].setMurBas(true);
        plateau[7][7].setMurGauche(true);

        plateau[7][8].setMurHaut(true);
        plateau[7][8].setMurDroit(true);
        plateau[7][8].setMurBas(true);
        plateau[7][8].setMurGauche(true);

        plateau[8][8].setMurHaut(true);
        plateau[8][8].setMurDroit(true);
        plateau[8][8].setMurBas(true);
        plateau[8][8].setMurGauche(true);

        plateau[8][7].setMurHaut(true);
        plateau[8][7].setMurDroit(true);
        plateau[8][7].setMurBas(true);
        plateau[8][7].setMurGauche(true);

        //      Murs AD

        plateau[8][5].setMurBas(true);
        plateau[8][5].setMurDroit(true);

        plateau[9][11].setMurBas(true);
        plateau[9][11].setMurGauche(true);

        plateau[10][2].setMurHaut(true);
        plateau[10][2].setMurDroit(true);

        plateau[11][14].setMurHaut(true);
        plateau[11][14].setMurDroit(true);

        plateau[12][9].setMurHaut(true);
        plateau[12][9].setMurGauche(true);

        plateau[13][4].setMurHaut(true);
        plateau[13][4].setMurGauche(true);

        plateau[14][6].setMurBas(true);
        plateau[14][6].setMurGauche(true);

        plateau[14][12].setMurBas(true);
        plateau[14][12].setMurDroit(true);















    }


//      TODO: MURS INTERNES (AD et Richard)



}
