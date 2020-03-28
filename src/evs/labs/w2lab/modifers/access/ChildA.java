/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.labs.w2lab.modifers.access;

/**
 * Child class contains members with access modifier
 * @author hassanjamil
 */
public class ChildA {
    private String name;
    public String centre;
    protected String email;
    /**
     * Parametric constructor to initialize object of {@link ChildA}
    * @param n name
    * @param c center
    * @param e email
     */
    public ChildA(String n, String c, String e) {
        this.name = n;
        this.centre = c;
        this.email = e;
    }
    
    public String getChangedName() {
        name += " John";
        return name;
    }
}
