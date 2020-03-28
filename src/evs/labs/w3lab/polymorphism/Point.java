/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.labs.w3lab.polymorphism;

/**
 *
 * @author hassanjamil
 */
public class Point {

    private float x, y;
    private int coords = 2;
    
    public Point() {}

    public Point(float x, float y) {
        setDataMembers(x, y);
    }

    private void setDataMembers(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public int getCoordsCount() {
        return coords;
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
