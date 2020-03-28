/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.labs.w2lab.modifers.nonaccess;

/**
 * Child class contains members with access modifier
 * @author hassanjamil
 */
public abstract class Child {
    public static String SNAME = "hassan";
    public final String fName;
    /** Parametric constructor to initialize object of {@link Child}
    * @param n name
    */
    public Child(String n) {
        this.fName = n;
    }
    
    public abstract void setNumber(int num);
}
