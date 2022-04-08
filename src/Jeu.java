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

        for (int i=0;i<taillePlateau;i++){
            int dernierePosition = taillePlateau-1;


            plateau[0][i].setMurHaut(true);
            plateau[dernierePosition][i].setMurBas(true);

            plateau[i][0].setMurGauche(true);
            plateau[i][dernierePosition].setMurGauche(true);
        }

        plateau[]
    }


}
