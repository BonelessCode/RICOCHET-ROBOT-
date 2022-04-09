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
    }

//      TODO: MURS INTERNES (AD et Richard)


}
