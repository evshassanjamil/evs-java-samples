/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.labs.w2lab.modifers.nonaccess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author hassanjamil
 */
public class TransientModifier  implements Serializable {
    
    private String path = "C:/Users/hassanjamil/Desktop/sample.txt";
    private String name, email;
    private transient String password;

    public TransientModifier() {
        
    }
    
    public TransientModifier(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public void writeInfoToFile(TransientModifier tm) {
        ObjectOutputStream out; 
        try {
            FileOutputStream fos = new FileOutputStream(path);

            out = new ObjectOutputStream(fos);
            out.writeObject(tm);
            out.flush();  

            out.close();  
            fos.close();  
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Write successfully, path: " + path);  
    }
    
    public void readInfoFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            TransientModifier tm = (TransientModifier) in.readObject();
            System.out.println(tm.name+", "+tm.email+", "+tm.password);  
            in.close(); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
