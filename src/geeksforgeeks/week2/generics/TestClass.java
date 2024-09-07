package geeksforgeeks.week2.generics;

public class TestClass<K, V> implements GenericInterface<K, V> {

    K k;
    V v;

    @Override
    public K func1(K k) {
        this.k = k;
        return k;
    }

    @Override
    public V fun2(V v) {
        this.v = v;
        return v;
    }
}
