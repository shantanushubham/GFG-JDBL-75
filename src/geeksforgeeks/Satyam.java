package geeksforgeeks;

import java.io.FileNotFoundException;

public class Satyam {

    MyClass myClass = new MyClass ();

    public void readFile() {
        try {
            myClass.readFile ();
        } catch (FileNotFoundException e) {
            System.out.println ( "Stops reading" );
        }
    }
}
