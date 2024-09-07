import geeksforgeeks.week1.Singleton;

public class Main {

    public static void main(String[] args) {
//        Singleton s = Singleton.getInstance ();
//        System.out.println (s.name);
//        s.name = "XYZ";
//        s = Singleton.getInstance ();
//        System.out.println (s.name);
        System.out.println (divideNumbers ( 5, 0 ));
    }

    public static double divideNumbers(int a, int b) {
        double val =  a / b;
        return val;
    }

}
