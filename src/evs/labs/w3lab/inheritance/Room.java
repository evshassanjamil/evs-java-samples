/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.labs.w3lab.inheritance;

/**
 *
 * @author hassanjamil
 */
public class Room extends Institute {
    
    private String id, type, timing, course;
    
    public Room() {}
    
    public Room(String id, String type, String timing, String course) {
        setDataMembers(id, type, timing, course);
    }
    
    public Room(String name, String location, String desc, 
            String id, String type, String timing, String course) {
        super(name, location, desc);
        setDataMembers(id, type, timing, course);
    }
    
    private void setDataMembers(String id, String type, String timing, String course) {
        this.id = id;
        this.type = type;
        this.timing = timing;
        this.course = course;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
}
