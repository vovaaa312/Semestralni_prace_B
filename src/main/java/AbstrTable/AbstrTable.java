package AbstrTable;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import AbstrTable.Iterator.FifoIterator;
import AbstrTable.Iterator.LifoIteraror;
import Enum.enumTypProhlidky;


public class AbstrTable<K extends Comparable<K>, V> implements IAbstrTable<K, V> {

    private Prvek koren;

    public AbstrTable() {
        this.koren = null;
    }

    @Override
    public void zrus() {
        koren = null;
        koren.setPocetPrvku(0);
    }

    @Override
    public boolean jePrazdny() {
        return pocetPrvku() == 0;
    }

    private int pocetPrvku() {
        return pocetPrvku(koren);
    }

    private int pocetPrvku(Prvek koren) {
        if (koren == null) return 0;
        else return koren.getPocetPrvku();
    }


    @Override
    public V najdi(K key) {
        return najdi(koren, key);
    }

    private V najdi(Prvek koren, K key) {
        if (key == null) throw new IllegalArgumentException();
        if (koren == null) return null;
        int cmp = key.compareTo((K) koren.getKlic());
        if (cmp < 0) return najdi(koren.getLevy(), key);
        else if (cmp > 0) return najdi(koren.getPravy(), key);
        else return (V) koren.getData();
    }

    @Override
    public void vloz(K key, V value) {
        if (key == null) throw new IllegalArgumentException();
        if (value == null) {
            odeber(key);
            return;
        }
        koren = vloz(koren, key, value);
    }

    private Prvek vloz(Prvek koren, K key, V value) {
        if (koren == null) return new Prvek(key, value, 1);
        int cmp = key.compareTo((K) koren.getKlic());
        if (cmp < 0) koren.setLevy(vloz(koren.getLevy(), key, value));
        else if (cmp > 0) koren.setPravy(vloz(koren.getPravy(), key, value));
        else koren.setData((value));
        koren.setPocetPrvku(1 + pocetPrvku(koren.getLevy()) + pocetPrvku(koren.getPravy()));
        return koren;
    }

    @Override
    public V odeber(K key) {
        if (key == null) throw new IllegalArgumentException();
        koren = odeber(koren, key);
        return (V) koren.getData();
    }

    private Prvek odeber(Prvek koren, K key) {
        if (koren == null) return null;
        int cmp = key.compareTo((K) koren.getKlic());
        if (cmp < 0) koren.setLevy(odeber(koren.getLevy(), key));
        else if (cmp > 0) koren.setPravy(odeber(koren.getPravy(), key));
        else {
            if (koren.getPravy() == null) return koren.getLevy();
            else if (koren.getLevy() == null) return koren.getPravy();
            Prvek pom = koren;
            koren = min(pom.getPravy());
            koren.setPravy(odeberMin(pom.getPravy()));
            koren.setLevy(pom.getLevy());

        }
        koren.setPocetPrvku(pocetPrvku(koren.getLevy()) + pocetPrvku(koren.getPravy()) + 1);
        return koren;
    }


    private Prvek odeberMin(Prvek koren) {
        if (koren.getLevy() == null) return koren.getPravy();
        koren.setLevy(odeberMin(koren.getLevy()));
        koren.setPocetPrvku((pocetPrvku(koren.getLevy()) + pocetPrvku(koren.getPravy()) + 1));
        return koren;
    }


    private Prvek min(Prvek prv) {
        if (prv.getLevy() == null) return prv;
        else return min(prv.getLevy());
    }


    @Override
    public Iterator<V> vytvorIterator(enumTypProhlidky typ) {
        return switch (typ) {
            case FIFO -> fifoIterator();
            case LIFO -> lifoIterator();
            case DEFAULT -> iterator();
        };
    }

    private Iterator<V> lifoIterator() {
        return (Iterator<V>) new LifoIteraror<Prvek>(koren);
    }

    private Iterator<V> fifoIterator(){
        return (Iterator<V>) new FifoIterator<Prvek>(koren);
    }

    @Override
    public Iterator<V> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super V> action) {
        IAbstrTable.super.forEach(action);
    }

    @Override
    public Spliterator<V> spliterator() {
        return IAbstrTable.super.spliterator();
    }
}
