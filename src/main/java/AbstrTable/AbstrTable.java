package AbstrTable;

import AbstrDoubleList.AbstrDoubleList;
import AbstrDoubleList.IAbstrDoubleList;

import java.util.Iterator;

import AbstrFifo.AbstrFifo;
import AbstrFifo.IAbstrFifo;
import AbstrLifo.AbstrLifo;
import AbstrLifo.IAbstrLifo;
import Enum.enumTypProhlidky;


public class AbstrTable<K extends Comparable<K>, V> implements IAbstrTable<K, V> {

    private IAbstrDoubleList<Prvek> list = new AbstrDoubleList<Prvek>();

    @Override
    public Iterator<V> iterator() {
        return null;
    }


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
//        if (!jePrazdny()) {
//            Iterator iter = list.iterator();
//            while (iter.hasNext()) {
//                Prvek prvek = (Prvek) iter.next();
//                if (prvek.klic.compareTo(key) == 0) {
//                    return prvek.value;
//                }
//            }
//        }
        if (!jePrazdny()) {
            list.zpristupniPrvni();
            for (Prvek prv : list) {
                if (prv.klic.compareTo(key) == 0) {
                    list.zpristupniPrvni();
                    return prv.value;
                }
                list.zpristupniNaslednika();
            }
        }

        return null;
    }

    @Override
    public void vloz(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
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
    public Iterator vytvorIterator(enumTypProhlidky typ) {
        switch (typ) {
            case SIRKA -> {
                return iteratorHloubky();
            }
            case HLOUBKA -> {
                return iteratorSirky();
            }
        }

        return null;
    }

    private Iterator iteratorSirky() {
        return new Iterator() {
            Prvek prvek;
            IAbstrFifo<Prvek> fifo = new AbstrFifo<Prvek>();

            @Override
            public boolean hasNext() {
                if (list.zpristupniPrvni() == null) return false;
                if (prvek == null) {
                    prvek = list.zpristupniPrvni();
                    return true;
                }
                return true;
            }

            @Override
            public V next() {
                if(!hasNext())return null;
                while (hasNext())return (V) fifo.odeber();
                return null;
            }
        };
    }

    public Iterator<V> iteratorHloubky() {
        return new Iterator() {
            Prvek prvek;
            IAbstrLifo<Prvek> lifo = new AbstrLifo<Prvek>();

            @Override
            public boolean hasNext() {
                if (list.zpristupniPrvni() == null) return false;
                if (prvek == null) {
                    prvek = list.zpristupniPrvni();
                    return true;
                }
                return true;
            }

            @Override
            public V next() {
                if(!hasNext())return null;
                while (hasNext())return (V) lifo.odeber();
                return null;
            }
        };
    }


}
