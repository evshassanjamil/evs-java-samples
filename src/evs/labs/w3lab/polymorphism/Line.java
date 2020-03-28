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
public class Line extends Point {
    private float x1, y1, x2, y2;
    private int coords = 4;

    public Line(float x1, float y1, float x2, float y2, int coords) {
        super(x1, y1);
        setDataMembers(x1, y1, x2, y2, coords);
    }
    
    private void setDataMembers(float x1, float y1, float x2, float y2, int coords) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.coords = coords;
    }

    public int getCoordsCount() {
        return coords;
    }
    public float getX() {
        return super.getX();
    }
    public float getY() {
        return super.getY();
    }

    public float getX2() {
        return x2;
    }
    public float getY2() {
        return y2;
    }
}
