package AbstrTable.Iterator;

import AbstrFifo.AbstrFifo;
import AbstrFifo.IAbstrFifo;
import AbstrTable.Prvek;

public class FifoIterator<T> {
    private IAbstrFifo<Prvek> fifo;

    public FifoIterator(Prvek koren) {
        this.fifo = new AbstrFifo<Prvek>();
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
