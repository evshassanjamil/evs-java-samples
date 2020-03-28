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
public class TestParentA {
    
    public static void main(String[] args) {
        ChildA c = new ChildA("David", "NASA", "abc@gmail.com");
        System.out.println(c.centre + "\n" + c.email + "\n" + c.getChangedName() + "\n");
        
        ParentA p = new ParentA("hassan", "evs", "evs.hassanjamil@gmail.com", 6);
        System.out.println(p.centre + "\n" + p.email + "\n" + p.number + "\n");
    }
    
}
