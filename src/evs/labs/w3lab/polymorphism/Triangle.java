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
public class Triangle extends Point {
    private float x1, y1, x2, y2, x3, y3;
    private int coords = 6;

    public Triangle(float x1, float y1, float x2, float y2, float x3, float y3, int coords) {
        super(x1, y1);
        setDataMembers(x1, y1, x2, y2, x3, y3, coords);
    }
    
    private void setDataMembers(float x1, float y1, float x2, float y2, float x3, float y3, int coords) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.coords = coords;
    }
    
    public int getCoordsCount() {
        return coords;
    }
}
