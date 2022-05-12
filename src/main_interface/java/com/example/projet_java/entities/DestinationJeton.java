package com.example.projet_java.entities;

public class DestinationJeton {
    String path;
    int id;
    int posx;
    int posy;
    String couleur;

    public DestinationJeton(int id, int posx, int posy, String path,String couleur) {

        this.id = id;
        this.posx = posx;
        this.posy = posy;
        this.path = path;
        this.couleur = couleur;

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

    public String getCouleur() {
        return couleur;
    }

    public int getId() {
        return id;
    }
}
