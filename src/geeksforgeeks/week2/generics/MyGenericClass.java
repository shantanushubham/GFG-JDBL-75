package geeksforgeeks.week2.generics;

public class MyGenericClass<T, K> {

    private T obj;

    private K obj2;

    MyGenericClass(T obj, K obj2) {
        this.obj = obj;
        this.obj2 = obj2;
    }

    public T getObj() {
        return this.obj;
    }

    public K getObj2() {
        return this.obj2;
    }

    public void testFunction(T t, K k) {
        System.out.println ( t );
        System.out.println ( k );
    }

    static <T, K> void printFunction(T t, K k) {
        System.out.println ( t );
        System.out.println ( k );
    }

}


class Demo {

    public static void main(String[] args) {
        MyGenericClass<String, Integer> gc = new MyGenericClass<> ( "Shantanu", 30 );
        gc.testFunction ( "Shantanu", 25);
    }
}

// You have a grocery list -> Vegetables, Oil, Toothpaste
// You have a stionary list -> Pencil, Eraser,

