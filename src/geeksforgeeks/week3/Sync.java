package geeksforgeeks.week3;

public class Sync {

    public static void main(String[] args) throws InterruptedException {
        Sender sender = new Sender ();
        ThreadSend t1 = new ThreadSend ( " Hi ", sender, 0 );
        ThreadSend t2 = new ThreadSend ( " How are you? ", sender, 0 );
        ThreadSend t3 = new ThreadSend ( " What's up? ", sender, 0 );
        t1.start ();
//        t1.join ();
        t2.start ();
//        t2.join ();
        t3.start ();
//        t3.join ();
    }
}

class Sender {

    public synchronized void send(String message) {
        System.out.println ( "Sending\t" + message );
        try {
            Thread.sleep ( 1000 );
        } catch (InterruptedException e) {
            System.out.println ( "Thread interrupted." );
        }
        System.out.println ( "\n" + message + " Sent" );
    }

}

class ThreadSend extends Thread {

    private final String message;
    final Sender sender;
    int time;

    ThreadSend(String message, Sender sender, int time) {
        this.message = message;
        this.sender = sender;
        this.time = time;
    }

    @Override
    public void run() {
        try {
            Thread.sleep ( time );
        } catch (InterruptedException e) {
            throw new RuntimeException ( e );
        }
        synchronized (sender) {
            sender.send ( message );
        }
    }
}

// 1. Synchronized block
// Resource R sync
// Process A -> 20 seconds (A uses R for 10 seconds, and then executes something else for 10 seconds)
// Process B -> 20 seconds (B uses R in from 5-20 seconds only)

/*
 * Without Multithreading -> 40s
 *
 * In multithreading -> 35s
 */

//  R1    R2
//  |     |
//  T1    T2

// T1 wants to use R1 and then use R2
// T2 wants to use R2 and then use R1


/*
1. NEW -> Thread created but not started
2. RUNNABLE -> The thread is ready to run and is waiting for the CPU time. When the start()
                is called, thread moves from NEW -> RUNNABLE
3. BLOCKED -> The thread is waiting for a monitor lock to enter or re-enter a synchronized
                block or method
4. WAITING -> The thread is waiting indefinitely for another thread to perform a specific action
5. TIMED_WAITING -> The thread is waiting for a specific period for another thread to perform a specific action
6. TERMINATED -> The thread has completed its execution.
 */
