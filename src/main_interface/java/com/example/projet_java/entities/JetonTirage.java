package com.example.projet_java.entities;

public class JetonTirage {
    String path;
    public int id;


    public JetonTirage(int id,String path) {
        this.id = id;
        this.path = path;

    }

    public int getId() {
        return id;
    }



    public String getPath() {
        return path;
    }
}
