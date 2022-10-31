package Pamatky;

import java.util.Iterator;
import Enum.enumTypKey;
import Enum.enumTypProhlidky;
import Zamek.Zamek;

public interface IPamatky<E> {

    int importDatTXT(String soubor);

    int vlozZamek(Zamek zamek);

    Zamek najdiZamek(String klic);

    Zamek odeberZamek(String klic);

    void zrus();

    void prebuduj();

    void nastavKlic(enumTypKey typ);

    Zamek najdiNejbliz(String klic);

    Iterator vytvorIterator(enumTypProhlidky typ);
}
