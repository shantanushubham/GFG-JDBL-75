package geeksforgeeks.week2.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MyStream {

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList ( 1, 2, 3, 4, 5, 6, 7 );
//        List<Integer> squaredNumbers = myList.stream ().map ( val -> val * val ).toList ();
        myList.parallelStream ().forEach ( el -> System.out.print (el) );
        System.out.println ();
        myList.parallelStream ().forEach ( el -> System.out.print (el) );
// Constant Pool -> String, Integer, Character, Double etc...
//        int maxVal =
//        System.out.println ( squaredNumbers );
//        List<List<Integer>> xyz = new ArrayList<> ();
//        xyz.add ( squaredNumbers );
//        xyz.add ( myList );
//        System.out.println ( xyz );
//        List<Integer> flattenedList = xyz.stream ().flatMap ( list -> list.stream () ).toList ();
//        System.out.println ( flattenedList );
//
//        List<Integer> inputList = new ArrayList<> ();
//        for (int i = 1; i <= 100; i++) {
//            inputList.add ( i );
//        }
//
//        Predicate<Integer> multipleOf5 = val -> val % 5 == 0;
//        Predicate<Integer> multipleOf7 = val -> val % 7 == 0;
//        List<Integer> multipleOf5and7 = inputList.stream ()
//                .filter ( multipleOf5.or ( multipleOf7 ) )
//                .toList ();
//        System.out.println ( multipleOf5and7 );
    }


}

/*

1. map()
2. filter()
3. sorted()
4. flatMap()
5. distinct()
6. peek()
7. reduce()
8. count()
9. max(), min()x
... and many more
 */

// Task. We will meet at 3:50 PM
// Given a list of numbers from 0 to 100 as a List<Integer>,
// filter those numbers that are multiples of 5 or 7, and store it in a list or set.
// Use stream() and filter() (use google for filter())

// Collection   ->   Stream   ->    Some special Function that you want to use