package AbstrTable;

import AbstrDoubleList.AbstrDoubleList;
import AbstrDoubleList.IAbstrDoubleList;

import java.util.Iterator;


public class AbstrTable<K extends Comparable<K>, V> implements IAbstrTable<K, V> {

    private IAbstrDoubleList<Prvek> list = new AbstrDoubleList<Prvek>();


    private class Prvek {
        K klic;
        V value;

        public Prvek(K klic, V value) {
            this.klic = klic;
            this.value = value;
        }
    }

    @Override
    public void zrus() {
        list.zrus();
    }

    @Override
    public boolean jePrazdny() {
        return list.jePrazdny();
    }

    @Override
    public V najdi(K key) {
        if (!jePrazdny()) {
            Iterator iter = list.iterator();
            while (iter.hasNext()) {
                Prvek prvek = (Prvek) iter.next();
                if (prvek.klic.compareTo(key) == 0) {
                    return prvek.value;
                }
            }
        }
        return null;
    }

    @Override
    public void vloz(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        list.vlozPosledni(new Prvek(key, value));
    }

    @Override
    public V odeber(K key) {
        V odeber = najdi(key);
        if (odeber != null) {
            list.odeberAktualni();
            return odeber;
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }


}
