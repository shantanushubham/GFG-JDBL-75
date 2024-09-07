package geeksforgeeks.week1;

public class Singleton {

    public String name;

    private static Singleton mySingletonInstance = null;

    private Singleton() {
        // My logic
        this.name = "GFG";
    }

    public static synchronized Singleton getInstance() {
        if (mySingletonInstance == null) {
            mySingletonInstance = new Singleton ();
        }
        return mySingletonInstance;
    }

}
