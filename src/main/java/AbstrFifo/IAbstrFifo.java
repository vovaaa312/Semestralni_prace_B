package AbstrFifo;

import java.util.Iterator;

public interface IAbstrFifo<T> {

    void zrus();
    boolean jePrazdny();

    void vloz(T data);
    T odeber();

    Iterator iterator();
}
