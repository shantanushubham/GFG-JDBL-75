package geeksforgeeks.week2.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Demo {

//    public static void main(String[] args) {
//        // Predicate (func - test)
//        Predicate<Integer> lessThan10 = x -> x < 10;
//        System.out.println ( lessThan10.negate ().test ( 5 ) );
//        Predicate<Integer> moreThan20 = x -> x > 20;
//        System.out.println ( lessThan10.or ( moreThan20 ).test ( 5 ) );
//    }
//
//    public boolean isSmallerThan10(int x) {
//        return x < 10;
//    }

//    public static void main(String[] args) {
//        // Consumer (func - accept)
//        final String name = "Shantanu Shubham";
//        Consumer<String> printFirstName = x ->
//                System.out.println ( x.split ( "\\s" )[0] );
////        printFirstName.accept ( "Shantanu Shubham" );
//        Consumer<String> printLastName = x ->
//                System.out.println ( x.split ( "\\s" )[1] );
////        printLastName.accept ( name );
//
//
//        printFirstName.andThen ( printLastName ).accept ( name );
//    }

    public static void main(String[] args) {
        // Function -- (func - apply())
        Function<Integer, Character> intToChar = asciiVal -> (char) asciiVal.intValue ();
        System.out.println ( intToChar.apply ( 100 ) );
        Function<String, Character> strToChar = str -> str.charAt ( 0 );
        System.out.println (strToChar.apply ( "Shantanu" ));

        // default Function

        // andThen()
        Function<Integer, Double> half = a -> a / 2.0;
        System.out.println ( half.andThen ( a -> 3 * a ).apply ( 10 ) );

        // compose()
        half = half.compose ( a -> 3 * a );
        System.out.println ( half.apply ( 5 ) );

        // identity()
        Function<String, String> i = Function.identity ();
        System.out.println ( i.apply ( "Shantanu" ) );

    }
}

