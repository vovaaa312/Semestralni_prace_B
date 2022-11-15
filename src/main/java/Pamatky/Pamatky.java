package Pamatky;

import AbstrTable.AbstrTable;
import Zamek.Zamek;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Iterator;

import Enum.enumTypKey;
import Enum.enumTypProhlidky;


public class Pamatky implements IPamatky {

    AbstrTable<String, Zamek> table = new AbstrTable<String, Zamek>();


    @Override
    public int importDatTXT() {
        String soubor = "D:\\учёба\\BDATS Datove struktury\\2022-2023\\vypracovane\\Semestralni_prace_B\\Semestralni_prace_B\\src\\main\\resources\\data.txt";
        int pocet = 0;
        try {
            FileReader fileReader = new FileReader(new File(soubor));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] nactenyZamek;
            Zamek zamek;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\\s+", ",");

                nactenyZamek = line.split(",");

                String id = null;
                String nazev = null;
                double x = 0;
                double y = 0;
                StringBuffer gps = new StringBuffer();

                switch (nactenyZamek.length) {
                    case 15 -> {
                        nazev = nactenyZamek[11];
                        id = nactenyZamek[1];
                        x = Double.parseDouble(nactenyZamek[3]);
                        y = Double.parseDouble(nactenyZamek[5]);
                        gps.append(nactenyZamek[2]).append(" ").append(nactenyZamek[3]).append(" ").append(nactenyZamek[4]).append(" ").append(nactenyZamek[5]);
                    }
                    case 16 -> {
                        nazev = nactenyZamek[11] + " " + nactenyZamek[12];
                        id = nactenyZamek[1];
                        x = Double.parseDouble(nactenyZamek[3]);
                        y = Double.parseDouble(nactenyZamek[5]);
                        gps.append(nactenyZamek[2]).append(" ").append(nactenyZamek[3]).append(" ").append(nactenyZamek[4]).append(" ").append(nactenyZamek[5]);
                    }
                    case 17 -> {
                        nazev = nactenyZamek[11] + " " + nactenyZamek[12] + " " + nactenyZamek[13];
                        id = nactenyZamek[1];
                        x = Double.parseDouble(nactenyZamek[3]);
                        y = Double.parseDouble(nactenyZamek[5]);
                        gps.append(nactenyZamek[2]).append(" ").append(nactenyZamek[3]).append(" ").append(nactenyZamek[4]).append(" ").append(nactenyZamek[5]);
                    }
                    case 18 -> {
                        nazev = nactenyZamek[11] + " " + nactenyZamek[12] + " " + nactenyZamek[13] + " " + nactenyZamek[14];
                        id = nactenyZamek[1];
                        x = Double.parseDouble(nactenyZamek[3]);
                        y = Double.parseDouble(nactenyZamek[5]);
                        gps.append(nactenyZamek[2]).append(" ").append(nactenyZamek[3]).append(" ").append(nactenyZamek[4]).append(" ").append(nactenyZamek[5]);
                    }
                }

                zamek = new Zamek(id, nazev, gps.toString(),x,y);
                if (zamek.getId() != null && zamek.getNazev() != null && gps.isEmpty()) {
                    table.vloz(zamek.getId(), zamek);
                }



                pocet++;
               // System.out.println(pocet + zamek.toString());

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
    public boolean jePrazdny() {
        return table.jePrazdny();
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
