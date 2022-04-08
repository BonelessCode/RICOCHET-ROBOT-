package components;

import java.util.List;

public class Cellule {
    boolean murHaut;
    boolean murDroit;
    boolean murBas;
    boolean murGauche;

    public void setMurHaut(boolean murHaut) {
        this.murHaut = murHaut;
    }

    public void setMurDroit(boolean murDroit) {
        this.murDroit = murDroit;
    }

    public void setMurBas(boolean murBas) {
        this.murBas = murBas;
    }

    public void setMurGauche(boolean murGauche) {
        this.murGauche = murGauche;
    }

    Position position;
}
