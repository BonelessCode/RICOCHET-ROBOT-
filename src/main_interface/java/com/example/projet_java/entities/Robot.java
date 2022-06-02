package com.example.projet_java.entities;

public class Robot {

    public String getCouleur() {
        return couleur;
    }

    String couleur;

    String path;

    static int positionBaseX;
    static int positionBaseY;

    int positionX;
    int positionY;

    public Robot(int positionX, int positionY, String couleur, String path) {
        this.positionBaseX = positionX;
        this.positionBaseY = positionY;

        this.positionX = positionX;
        this.positionY = positionY;

        this.path = path;

        this.couleur = couleur;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }

    public static int getPositionBaseX() {
        return positionBaseX;
    }
    public static int getPositionBaseY() {
        return positionBaseY;
    }

    public String getPath() {
        return path;
    }
}


