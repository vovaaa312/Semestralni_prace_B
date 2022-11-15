package Zamek;

public abstract class AbstrZamek<T> {
    private String id;
    private String nazev;
    private String gps;

    private double x, y;


    public AbstrZamek(String id, String nazev, String gps, double x, double y) {
        this.id = id;
        this.nazev = nazev;
        this.gps = gps;
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }

    public String getGps() {
        return gps;
    }

    public double getXY() {
        return x + y;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nazev: " + nazev + " gps: " + gps + " x: " + x + " y: " + y;
    }
}
