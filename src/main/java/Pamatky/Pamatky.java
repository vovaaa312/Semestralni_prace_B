package Pamatky;

import AbstrTable.AbstrTable;
import Zamek.Zamek;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Iterator;

import Enum.enumTypKey;
import Enum.enumTypProhlidky;


public class Pamatky<E> implements IPamatky<E> {

    AbstrTable<String, Zamek> table = new AbstrTable<String, Zamek>();

    @Override
    public int importDatTXT(String soubor) {
        int pocet = 0;
        try {
            FileReader fileReader = new FileReader(new File(soubor));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] nactenyZamek;
            Zamek zamek;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\\s+", " ");
                nactenyZamek = line.split(" ");

                String id = null;
                String nazev = null;
                Double sirka = 0.0;
                Double vyska = 0.0;

                switch (nactenyZamek.length) {
                    case 15 -> {
                        sirka = Double.parseDouble(nactenyZamek[3]);
                        vyska = Double.parseDouble(nactenyZamek[5]);
                        nazev = nactenyZamek[11];
                        id = nactenyZamek[1];
                    }
                    case 16 -> {
                        sirka = Double.parseDouble(nactenyZamek[3]);
                        vyska = Double.parseDouble(nactenyZamek[5]);
                        nazev = nactenyZamek[11] + " " + nactenyZamek[12];
                        id = nactenyZamek[1];
                    }
                    case 17 -> {
                        sirka = Double.parseDouble(nactenyZamek[3]);
                        vyska = Double.parseDouble(nactenyZamek[5]);
                        nazev = nactenyZamek[11] + " " + nactenyZamek[12] + " " + nactenyZamek[13];
                        id = nactenyZamek[1];
                    }
                    case 18 -> {
                        sirka = Double.parseDouble(nactenyZamek[3]);
                        vyska = Double.parseDouble(nactenyZamek[5]);
                        nazev = nactenyZamek[11] + " " + nactenyZamek[12] + " " + nactenyZamek[13] + " " + nactenyZamek[14];
                        id = nactenyZamek[1];
                    }
                }
                zamek = new Zamek(id, nazev, sirka, vyska);
                table.vloz(zamek.getId(), zamek);
                pocet++;
//                for (int i = 0; i < nactenyZamek.length; i++) {
//                    System.out.print(nactenyZamek[i] + ",,");
//                }


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pocet;
    }

    @Override
    public int vlozZamek(Zamek zamek) {
        table.vloz(zamek.getNazev(), zamek);
        return 1;
    }

    @Override
    public Zamek najdiZamek(String klic) {
        return table.najdi(klic);
    }

    @Override
    public Zamek odeberZamek(String klic) {
        return table.odeber(klic);
    }

    @Override
    public void zrus() {
        table.zrus();
    }

    @Override
    public void prebuduj() {

    }

    @Override
    public Zamek najdiNejbliz(String klic) {
        return null;
    }

    @Override
    public Iterator vytvorIterator(enumTypProhlidky typ) {
        return table.vytvorIterator(typ);
    }

    @Override
    public void nastavKlic(enumTypKey typ) {

    }
}
