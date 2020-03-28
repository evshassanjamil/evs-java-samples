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
public class Parent extends Child {
    public int number;
    
    private volatile String vName = "William";
    
    public synchronized String getSyncName() {
        return "Bruce";
    }
    
    public Parent(String name, int number) {
        super(name);
        this.number = number;
    }
    
    public String getVoltName() {
        return vName;
    }

    @Override
    public void setNumber(int num) {
        this.number = num;
    }
}
