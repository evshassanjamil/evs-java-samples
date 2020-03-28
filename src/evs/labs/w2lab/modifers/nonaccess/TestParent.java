/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.labs.w2lab.modifers.nonaccess;

/**
 *
 * @author hassanjamil
 */
public class TestParent {
    public static void main(String[] args) {
//        Parent p = new Parent("David", 8);
//        Child c = p;
//        c.setNumber(0);
//        
//        System.out.println(p.fName + "\n" + p.number + "\n" +
//                Child.SNAME + "\n" + p.getSyncName() + "\n" + p.getVoltName());
        
//        TransientModifier tm1 = new TransientModifier("Raymond", "raymond@gmail.com", "123!@#qweasd");
//        tm1.writeInfoToFile(tm1);
        
        TransientModifier tm2 = new TransientModifier();
        tm2.readInfoFromFile();
    }
}
