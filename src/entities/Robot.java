package entities;

import components.Position;

public class Robot {

    public String getCouleur() {
        return couleur;
    }

    String couleur;

    int positionBaseX;
    int positionBaseY;

    int positionX;
    int positionY;

    public Robot(int positionX, int positionY, String couleur) {
        this.positionBaseX = positionX;
        this.positionBaseY = positionY;

        this.positionX = positionX;
        this.positionY = positionY;

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
}
