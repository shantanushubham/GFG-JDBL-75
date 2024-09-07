package geeksforgeeks.week2.lambda;

public interface FuncInterface {

    default void name() {
        System.out.println ( "Hello" );
    }

    int test(String a);

    static void myName() {
        System.out.println ( "XYZ" );
    }

}

interface SubbaInterface {

    String getLastName();

}

interface MetroEngine {
    void start();
}


//class Test implements FuncInterface {
//
//    public void test() {
//        System.out.println ("Inside Test function");
//    }
//
//    public void classFunc() {
//        System.out.println ("XYZ");
//    }
//
//}

class Main {

    static String name;

    public static void main(String[] args) {
//        Test t = new Test ();
//        t.test ();
//        t.name();
//        t.classFunc ();


//        FuncInterface f = new FuncInterface () {
//            @Override
//            public void test() {
//                System.out.println ( "Inside Test function" );
//            }
//        };
//        f.test ();
//        f.name ();

        /*my lambda function */
        FuncInterface f = name -> 0;
        f.test ( "Shantanu" );
        f.name ();
        FuncInterface.myName ();

        SubbaInterface s = () -> "Rao";
        System.out.println (s.getLastName ());

        MetroEngine driverEngine = () -> System.out.println ("Starting with Driver");
        MetroEngine driverlessEngine = () -> System.out.println ("Starting without Driver");

        driverEngine.start ();
        driverlessEngine.start ();

    }

}

// Lets meet at 3:15 PM
// Create an interface called MetroEngine that must have an abstract function called as "start"
// A metro engine can be of 2 types:
// 1. Driver based engine -- Prints "Starting with Driver"
// 2. Driver-less engine -- Prints "Starting without Driver"

// Create two instances of MetroEngine and use the start() function. Use Lambdas only!