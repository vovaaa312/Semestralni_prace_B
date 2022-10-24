package Zamek;

public abstract class AbstrZamek {
    private String id;
    private String nazev;
    private Double sirka, vyska;

    public AbstrZamek(String id, String nazev, Double sirka, Double vyska) {
        this.id = id;
        this.nazev = nazev;
        this.sirka = sirka;
        this.vyska = vyska;
    }
}
