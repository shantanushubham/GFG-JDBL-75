package geeksforgeeks.week3;

public class MT {

    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread ( new MyThread () );
//        Thread t2 = new Thread ( new MyThread () );
//        Thread t3 = new Thread ( new MyThread () );
//        t1.start ();
//        try {
//            System.out.println ("Current Thread: " + Thread.currentThread ().getName ());
////            t1.join ();
//            t1.interrupt ();
//        } catch (Exception e) {
//            System.out.println ( "Exception occurred! " + e );
//        }
//        t2.start ();
//        try {
//            System.out.println ("Current Thread: " + Thread.currentThread ().getName ());
//            t2.join ();
//        } catch (Exception e) {
//            System.out.println ( "Exception occurred! " + e );
//        }
//        t3.start ();
//        try {
//            System.out.println ("Current Thread: " + Thread.currentThread ().getName ());
////            t3.join ();
//        } catch (Exception e) {
//            System.out.println ( "Exception occurred! " + e );
//        }

        Thread t = new Thread ( () -> {
            for (int i = 0; i < 1000; i++) {
                if (Thread.currentThread ().isInterrupted ()) {
                    System.out.println ( Thread.currentThread ().getName () + " was interrupted. Exiting ..." );
                    break;
                }
                System.out.println ( Thread.currentThread ().getName () + " - Count: " + i );
                try {
                    Thread.sleep ( 1000 );
                } catch (InterruptedException e) {
                    System.out.println ( Thread.currentThread ().getName () + " was interrupted during sleep." );
//                    Thread.currentThread ().interrupt ();
                    break;
                }
            }
        } );
        t.start ();
        try {
            Thread.sleep ( 50 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        t.join ();
        t.interrupt ();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
//                Thread.sleep ( 500 );
                System.out.println ( "Current Thread: " + Thread.currentThread ().getName () );
            } catch (Exception e) {
                System.out.println ( "Exception occurred! " + e );
            }
            System.out.println ( i );
        }
    }
}