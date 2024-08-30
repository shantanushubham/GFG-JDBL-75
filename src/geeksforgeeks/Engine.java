package geeksforgeeks;

//public abstract class Engine {
//
//    public String propertyA;
//    public String propertyB;
//
//    public abstract void start();
//
//    public abstract void stop();
//
//    public void getEngineInfo() {
//        System.out.println ( "This is Engine info" );
//    }
//
//}

import exceptions.EngineFailureException;

public interface Engine {

    String engineCompany = "Pratt & Whiteny";

    void start();

    void stop();

    default void test() {
        System.out.println ( "test function" );
    }

}
