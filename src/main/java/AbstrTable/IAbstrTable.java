package AbstrTable;

import java.util.Iterator;


public interface IAbstrTable<K extends Comparable<K>, V> extends Iterable<V> {

    void zrus();

    boolean jePrazdny();

    V najdi(K key);

    void vloz (K key, V value);

    V odeber(K key);

    Iterator iterator();


}
