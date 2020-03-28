/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.labs.w2lab.modifers.access;

/**
 *
 * @author hassanjamil
 */
public class ParentA extends ChildA {
    protected int number;
    int age;
    
    public ParentA(String n, String c, String e, int num) {
        super(n, c, e);
        this.number = num;
    }
}
