package Pamatky;

import BVS.AbstrTable;
import Zamek.Zamek;

import java.util.Iterator;

import Enum.enumTypKey;


public class Pamatky<E>implements IPamatky<E> {

    AbstrTable<AbstrTable, String> iAbstrTable = new AbstrTable<AbstrTable, String>();

    @Override
    public int importDatTXT() {
        return 0;
    }

    @Override
    public int vlozZamek(Zamek zamek) {
        return 0;
    }

    @Override
    public Zamek najdiZamek(String klic) {
        return null;
    }

    @Override
    public Zamek odeberZamek(String klic) {
        return null;
    }

    @Override
    public void zrus() {

    }

    @Override
    public void prebuduj() {

    }

    @Override
    public Zamek najdiNejbliz(String klic) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void nastavKlic(enumTypKey typ) {

    }
}