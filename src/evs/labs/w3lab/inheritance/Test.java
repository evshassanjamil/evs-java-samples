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
public class Test {

    public static void main(String[] args) {
        Room room = new Room("EVS", "Rehmanabad Metro Stop, Murree Road, Rawalpindi",
                "EVS is a professtional training institute",
                "room102", "Android App Development", "2019-11-30 15:30:00", "Lecture Class");
        printRoom(room);
        printDivider();
        
        Institute i = room;
        printInstitute(i);
         printDivider();

        //printInstitute((Institute) room);    // Equals Institute i = room;
    }

    private static void printInstitute(Institute institute) {
        System.out.println(institute.getName() + "\n"
                + institute.getLocation() + "\n"
                + institute.getDesc());
    }

    private static void printRoom(Room room) {
        System.out.println(room.getId() + "\n"
                + room.getType() + "\n"
                + room.getCourse() + "\n"
                + room.getTiming());
    }

    private static void printDivider() {
        System.out.println("---------------");
    }
}
