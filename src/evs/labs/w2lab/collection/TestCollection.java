/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.labs.w2lab.collection;

import java.util.*;

/**
 * @author hassanjamil
 */
public class TestCollection {
    public static void main(String[] args) {
        execCollection();
        execLinkedList();
        execStack();
        execQueue();
        execHashMap();
    }

    public static void execCollection() {
        System.out.println("ArrayList\n--------------");
        ArrayList<String> listNames = new ArrayList<>();
        listNames.add("Amanda");
        listNames.add("Bruce");
        listNames.add("Catherine");
        listNames.add("Daniel");
        listNames.add("Evan");
        Iterator iterator = listNames.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("\n");
    }

    public static void execLinkedList() {
        System.out.println("LinkedList\n--------------");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Bruce");
        linkedList.add("Catherine");
        linkedList.add("Daniel");
        linkedList.add("Eve");

        System.out.println("First Element: " + linkedList.getFirst());
        System.out.println("Last Element: " + linkedList.getLast());

        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("\n");
    }

    public static void execStack() {
        System.out.println("Stack\n--------------");
        Stack<String> stack = new Stack<>();
        stack.push("Bruce");
        stack.push("Catherine");
        stack.push("Daniel");

        System.out.println("Pop Element: " + stack.pop());

        Iterator iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("\n");
    }

    public static void execQueue() {
        System.out.println("PriorityQueue\n--------------");
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Amanda");
        queue.add("Bruce");
        queue.add("Catherine");
        queue.add("Daniel");
        queue.add("Emilie");
        System.out.println("poll: " + queue.poll());
        System.out.println("element: " + queue.element());
        System.out.println("peek: " + queue.peek());

        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("\n");
    }

    public static void execHashMap() {
        System.out.println("HashMap\n--------------");
        HashMap<String, String> hashMapNames = new HashMap<>();
        hashMapNames.put("1", "Amanda");
        hashMapNames.put("2", "Bruce");
        hashMapNames.put("3", "Catherine");
        hashMapNames.put("4", "Daniel");
        hashMapNames.put("5", "Emilie");

        String key = "4";
        System.out.println("Value against key=" + key + " is: " + hashMapNames.get(key));
    }
}
