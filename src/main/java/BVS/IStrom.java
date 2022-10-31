package BVS;

public interface IStrom<T> {

    void zrus();

    boolean jePrazdny();

    int pocetPrvku();

    void prohlidka();

    void vlozKoren(T data);

    void vlozPravyList(T otec, T data);

    void vlozLevyList(T otec, T data);

    T odeberLevyList(T otec);

    T odeberPravyList(T otec);

    T zpristupniKoren();

    T zpristupniOtce(T syn);

    T zpristupniPravehoSyna(T otec);

    T zpristupniLevehoSyna(T otec);

    T zpristupniBratra(T koho);

}
