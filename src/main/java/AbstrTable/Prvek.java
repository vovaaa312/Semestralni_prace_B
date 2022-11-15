package AbstrTable;

public class Prvek<K, V> {
   private K klic;
   private V data;
   private Prvek levy, pravy;
   private int pocetPrvku;

    public Prvek(K klic, V data, int pocetPrvku) {
        this.klic = klic;
        this.data = data;

        this.pocetPrvku = pocetPrvku;
    }

    public K getKlic() {
        return klic;
    }

    public void setKlic(K klic) {
        this.klic = klic;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public Prvek getLevy() {
        return levy;
    }

    public void setLevy(Prvek levy) {
        this.levy = levy;
    }

    public Prvek getPravy() {
        return pravy;
    }

    public void setPravy(Prvek pravy) {
        this.pravy = pravy;
    }

    public int getPocetPrvku() {
        return pocetPrvku;
    }

    public void setPocetPrvku(int pocetPrvku) {
        this.pocetPrvku = pocetPrvku;
    }
}
