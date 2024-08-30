import geeksforgeeks.Singleton;

public class Main {

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance ();
        System.out.println (s.name);
        s.name = "XYZ";
        s = Singleton.getInstance ();
        System.out.println (s.name);
    }

}
