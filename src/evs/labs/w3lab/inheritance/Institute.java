/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.labs.w3lab.inheritance;

/**
 * Institute class represents Institute Entity
 * @author hassanjamil
 */
public class Institute {
    
    private String name, location, desc;
    public Institute() {}           // Non-parametric constructor
    
    public Institute(String name, String location, String desc) {   // Parametric constructor
        this.name = name;
        this.location = location;
        this.desc = desc;
    }

    /**
     * Get the name of institute
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of institute
     * @param name {@link String} name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * To get the location of institute
     * @return {@link String} value
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the location of institute
     * @param location {@link String} location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get the description of institute
     * @return 
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Set the description of institute
     * @param desc {@link String} value
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
