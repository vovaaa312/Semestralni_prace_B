package AbstrLifo;

import AbstrDoubleList.AbstrDoubleList;

import java.util.Iterator;

public class AbstrLifo<T> implements IAbstrLifo<T> {
    AbstrDoubleList<T>abstrDoubleList = new AbstrDoubleList<T>();

    //zruseni seznamu zasobniku
    @Override
    public void zrus() {
    abstrDoubleList.zrus();
    }

    //kontrola jestli zasobnik je prazdny
    @Override
    public boolean jePrazdny() {
        return abstrDoubleList.jePrazdny();
    }

    //vlozeni prvku na posledni pozice
    @Override
    public void vloz(T data) {
    abstrDoubleList.vlozPosledni(data);
    }

    //odebirani prvku z posledni pozice
    @Override
    public T odeber() {
        return abstrDoubleList.odeberPosledni();
    }

    @Override
    public Iterator iterator() {
        return abstrDoubleList.iterator();
    }
}
