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
public class Test {

    public static void main(String[] args) {
        Point point1 = new Point(0f, 0f);
        System.out.println(point1.getCoordsCount());
        
        Point point2 = new Line(0.1f, 0.1f, 1f, 1f, 4);
        System.out.println(point2.getCoordsCount());
        System.out.println(point2.getX());
        System.out.println(point2.getY());
        System.out.println(((Line) point2).getX2());
        System.out.println(((Line) point2).getY2());

        Point point3 = new Triangle(0.3f, 0.3f, 1f, 1f, 2f, 2f, 6);
        System.out.println(point3.getCoordsCount());
    }
}
