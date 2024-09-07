package geeksforgeeks.week1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class MyClass {

    public String firstName;
    public static String lastName = "Sharma";
    public static Map<String, String> map = new HashMap<> ();

//    public MyClass() {
//        System.out.println ( "Inside Constructor" );
//    }

    static {
        map.put ( "Karnataka", "Bengaluru" );
        map.put ( "Jharkhand", "Ranchi" );
        map.put ( "Maharashtra", "Mumbai" );
        map.put ( "Telangana", "Hyderabad" );
        map.put ( "Uttar Pradesh", "Lucknow" );
    }

    /**
     * Karnataka -> Bengaluru
     * Jharkhand -> Ranchi
     * Maharashtra -> Mumbai
     * Telangana -> Hyderabad
     * Uttar Pradesh -> Lucknow
     */


    public static int addTwoNumbers(int a, int b) {
        return a + b;
    }

    public void readFile() throws FileNotFoundException {
        FileReader f = new FileReader ( "src/someFile.txt" );
    }

}
