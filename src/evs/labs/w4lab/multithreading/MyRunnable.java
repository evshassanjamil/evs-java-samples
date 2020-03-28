package evs.labs.w4lab.multithreading;

public class MyRunnable implements Runnable {
    private Thread t;
    private String name;
    private long sleep;
    private int priority;

    MyRunnable(String name, long sleep, int priority) {
        this.name = name;
        this.sleep = sleep;
        this.priority = priority;
        System.out.println("Creating " + this.name);
    }

    public void run() {
        System.out.println("Running " + name);
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("Thread: " + name + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(sleep);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " interrupted.");
        }
        System.out.println("Thread " + name + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + name);
        if (t == null) {
            t = new Thread(this, name);
            t.setPriority(priority);
            t.start();
        }
    }
}
