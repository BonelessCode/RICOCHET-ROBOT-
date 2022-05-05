package entities;

public class DestinationJeton {
    String path;
    int id;
    int posx;
    int posy;

    public DestinationJeton(int id, int posx, int posy) {

        this.id = id;
        this.posx = posx;
        this.posy = posy;

    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }
}
