package Pamatky;

import java.util.Iterator;
import Enum.enumTypKey;
import Enum.enumTypProhlidky;
import Zamek.Zamek;

public interface IPamatky {

    int importDatTXT();

    int vlozZamek(Zamek zamek);

    Zamek najdiZamek(String klic);

    Zamek odeberZamek(String klic);

    boolean jePrazdny();

    void zrus();

    void prebuduj();

    void nastavKlic(enumTypKey typ);

    Zamek najdiNejbliz(String klic);

    Iterator vytvorIterator(enumTypProhlidky typ);
}
