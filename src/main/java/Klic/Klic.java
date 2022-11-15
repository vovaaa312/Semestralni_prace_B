package Klic;

import Zamek.Zamek;
import Enum.enumTypKey;

public class Klic<T>implements Comparable<T>{
    private Zamek zamek;
    private enumTypKey typKey;

    public Klic(Zamek zamek, enumTypKey typKey) {
        this.zamek = zamek;
        this.typKey = typKey;

    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
