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

    public String getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }

    public Double getSirka() {
        return sirka;
    }

    public Double getVyska() {
        return vyska;
    }

    @Override
    public String toString() {
        return "ID: " + id +" Nazev: " + nazev + " sirka: " + sirka + " vyska: " + vyska;
    }
}
