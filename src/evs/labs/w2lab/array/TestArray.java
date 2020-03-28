/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.labs.w2lab.array;

/**
 *
 * @author hassanjamil
 */
public class TestArray {
    public static void funcArray() {
        String[] arrNames = new String[5];
        arrNames[0] = "Akon";
        arrNames[1] = "Bruce";
        arrNames[2] = "Catherine";
        arrNames[3] = "Daniel";
        arrNames[4] = "Evan";
        for (int i = 0; i < arrNames.length; i++) {
            String name;
            if (i < arrNames.length - 1) {
                name = arrNames[i] + ", ";
                System.out.print(name);
            } else {
                name = arrNames[i];
                System.out.println(name);
            }
        }
    }
    public static void main(String[] args) {
        funcArray();
    }
            
}
