package Enum;

public enum enumTypProhlidky {
    FIFO("fifo"), LIFO("lifo"),
    DEFAULT("DEFAULT");

    private final String nazev;

    enumTypProhlidky(String nazev) {
        this.nazev = nazev;
    }
}
