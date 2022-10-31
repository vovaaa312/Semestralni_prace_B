package BVS;

public class Strom<T> implements IStrom<T> {
    private Prvek<T> koren;
    private Prvek<T> aktualni;
    private int pocetPrvku;

    @Override
    public void zrus() {
        koren = null;
        aktualni = null;
        pocetPrvku = 0;
    }

    @Override
    public boolean jePrazdny() {
        return pocetPrvku == 0;
    }

    @Override
    public int pocetPrvku() {
        return pocetPrvku;
    }

    @Override
    public void prohlidka() {

    }

    @Override
    public void vlozKoren(T data) {
        if (data == null) throw new NullPointerException();
        if (koren != null) return;
        koren = new Prvek<>(data, null, null, null);
        aktualni = koren;
        pocetPrvku++;
    }

    @Override
    public void vlozPravyList(T otec, T data) {
        if (koren == null || data == null || otec == null || jePrazdny()) throw new NullPointerException();
//        Prvek prvek = (Prvek) otec;
//        prvek.pravy = new Prvek(data, null, null);
        aktualni = (Prvek<T>) otec;
        aktualni.levy = new Prvek(data, null, null, aktualni);
        aktualni = aktualni.levy;
        pocetPrvku++;

    }

    @Override
    public void vlozLevyList(T otec, T data) {
        if (koren == null || data == null || otec == null || jePrazdny()) throw new NullPointerException();
//        Prvek prvek = (Prvek) otec;
//        prvek.levy = new Prvek(data, null, null);
        aktualni = (Prvek<T>) otec;
        aktualni.pravy = new Prvek(data, null, null, aktualni);
        aktualni = aktualni.pravy;
        pocetPrvku++;
    }

    @Override
    public T odeberLevyList(T otec) {
        if (otec == null) throw new NullPointerException();
        Prvek prvekOtec = (Prvek) otec;
        Prvek levy = prvekOtec.levy;
        prvekOtec.levy = null;

        return (T) levy.value;
    }

    @Override
    public T odeberPravyList(T otec) {
        if (otec == null) throw new NullPointerException();
        Prvek prvekOtec = (Prvek) otec;
        Prvek pravy = prvekOtec.pravy;
        prvekOtec.pravy = null;

        return (T) pravy.value;
    }

    @Override
    public T zpristupniKoren() {
        return koren.value;
    }

    @Override
    public T zpristupniOtce(T syn) {
        return (T) aktualni.otec.value;
    }

    @Override
    public T zpristupniPravehoSyna(T otec) {
        return (T) aktualni.pravy;
    }

    @Override
    public T zpristupniLevehoSyna(T otec) {
        return (T) aktualni.levy;
    }

    @Override
    public T zpristupniBratra(T koho) {
        if(koho == null || jePrazdny())throw new NullPointerException();
        Prvek prvek = (Prvek) koho;
        if (prvek.otec.levy == koho)
            return zpristupniPravehoSyna((T) prvek);
        else return zpristupniLevehoSyna((T) prvek);
    }



    private class Prvek<T> {
        public T value;
        public Prvek levy;
        public Prvek pravy;
        public Prvek otec;

        public Prvek(T value, Prvek levy, Prvek pravy, Prvek otec) {
            this.value = value;
            this.levy = levy;
            this.pravy = pravy;
            this.otec = otec;
        }
    }


}
