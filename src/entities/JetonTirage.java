package entities;

public class JetonTirage {
    String path;
    int id;


    public JetonTirage(int id,String path) {
        this.id = id;
        this.path = path;

    }

    public int getId() {
        return id;
    }
}
