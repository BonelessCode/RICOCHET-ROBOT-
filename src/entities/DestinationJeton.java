package entities;

public class DestinationJeton {
    String path;
    int id;
    int posx;
    int posy;

    public DestinationJeton(int id, int posx, int posy, String path) {

        this.id = id;
        this.posx = posx;
        this.posy = posy;
        this.path = path;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }


    public String getPath() {
        return path;
    }
}
