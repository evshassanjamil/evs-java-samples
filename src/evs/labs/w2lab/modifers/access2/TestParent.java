/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.labs.w2lab.modifers.access2;

import evs.labs.w2lab.modifers.access.ChildA;

/**
 *
 * @author hassanjamil
 */
public class TestParent extends ChildA {
    
    public TestParent(String n, String c, String e) {
        super(n, c, e);
    }
    
    public static void main(String[] args) {
        TestParent c = new TestParent("David", "NASA", "abc@gmail.com");
        System.out.println(c.centre + "\n" + c.email);
    }
    
}
