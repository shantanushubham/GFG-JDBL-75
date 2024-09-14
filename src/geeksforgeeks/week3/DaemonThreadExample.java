package geeksforgeeks.week3;

public class DaemonThreadExample {

    public static void main(String[] args) {
        Thread daemonThread = new Thread (() -> {
            while (true) {
                System.out.println ("Daemon Thread is running...");
                try {
                    Thread.sleep ( 1000 ); // Simulating some work
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        });
        daemonThread.setDaemon ( true );
        daemonThread.start ();
        System.out.println ("Main Thread exiting ...");
    }

}
