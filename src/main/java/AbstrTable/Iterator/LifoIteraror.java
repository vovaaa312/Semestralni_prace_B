package AbstrTable.Iterator;

import AbstrLifo.AbstrLifo;
import AbstrLifo.IAbstrLifo;
import AbstrTable.Prvek;

public class LifoIteraror<T>{
    private IAbstrLifo<Prvek> fifo;

    public LifoIteraror(Prvek koren) {
        this.fifo = new AbstrLifo<Prvek>();
        Prvek akt = koren;
        while (akt != null) {
            fifo.vloz(akt);
            akt = akt.getLevy();
        }
    }

    public boolean hasNext() {
        return !fifo.jePrazdny();
    }

    public T next() {
        Prvek prv = fifo.odeber();
        Prvek akt = prv.getPravy();
        while (akt != null)
        {
            fifo.vloz(akt);
            akt = akt.getLevy();
        }
        return (T) prv.getData();
    }
}
