package BVS;

public class Strom<T> implements IStrom<T> {
    private Prvek<T> koren;
    private Prvek<T>aktualni;
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
        if(data == null)throw new NullPointerException();
        if(koren !=null)return;
        koren = new Prvek<>(data, null, null);
        aktualni = koren;
        pocetPrvku++;
    }

    @Override
    public void vlozPravyList(T otec, T data) {
        if(koren == null || data == null)throw new NullPointerException();

    }

    @Override
    public void vlozLevyList(T otec, T data) {

    }

    @Override
    public T odeberLevyList(T otec) {
        return null;
    }

    @Override
    public T odeberPravyList(T otec) {
        return null;
    }

    @Override
    public T zpristupniKoren() {
        return null;
    }

    @Override
    public T zpristupniOtce(T syn) {
        return null;
    }

    @Override
    public T zpristupniPravehoSyna(T otec) {
        return null;
    }

    @Override
    public T zpristupniLevehoSyna(T otec) {
        return null;
    }

    @Override
    public T zpristupniBratra(T koho) {
        return null;
    }

    @Override
    public void vloz() {

    }

    private class Prvek<T>{
        public T value;
        public Prvek levy, pravy;

        public Prvek(T value, Prvek levy, Prvek pravy) {
            this.value = value;
            this.levy = levy;
            this.pravy = pravy;
        }
    }


}
