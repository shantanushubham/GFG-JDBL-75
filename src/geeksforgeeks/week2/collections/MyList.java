package geeksforgeeks.week2.collections;

import java.util.*;

public class MyList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<> (); // [][][][]
        List<Integer> linkedList = new LinkedList<> ();// []->[]->[]->[]
        list.add ( 1 );
        list.add ( 2 );
        list.add ( 3 );
        System.out.println (list);
//        for (int i : list) {
//            linkedList.add ( i );
//        }
        linkedList.addAll ( list );
        list.get ( 3 );


        Set<Integer> set = new HashSet<> (); // unordered set
        Set<Integer> set1 = new LinkedHashSet<> (); // ordered set
        Set<Integer> set2 = new TreeSet<> (); // sorted set
        set.add ( 1 );
        set.add ( 1 );
        set.remove ( 9 );
        System.out.println ( set.contains ( 1 ) );


        Map<Integer, Integer> map = new HashMap<> (); // unordered map
        Map<Integer, Integer> map1 = new LinkedHashMap<> (); // ordered map
        Map<Integer, Integer> map2 = new TreeMap<> (); // sorted map
        map.put ( 1, 1 );
        map.remove ( 9 );


        Queue<Integer> q = new LinkedList<> (); // DLL
        Queue<Integer> q1 = new PriorityQueue<> (); // heap
        Queue<Integer> q2 = new ArrayDeque<> (); // circular queue (double ended queue)
        q.poll ();
        q.add (5);
        q.offer (  5);
        q.size ();
        q.isEmpty ();
        q.peek ();
    }

    // [][][][][][][][][][][]
}
