package evs.labs.w4lab.multithreading;

public class TestMultiThreading {
    public static void main(String[] args) {

        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Do your operations here
            }
        },"Thread-0");
        thread.start();*/
        
        MyRunnable R1 = new MyRunnable("Thread-1", 1000, 1);
        R1.start();

        MyRunnable R2 = new MyRunnable("Thread-2", 1000, 1);
        R2.start();
    }
}
