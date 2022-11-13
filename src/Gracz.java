public class Gracz implements Comparable<Gracz>{

    private String imie;
    private int wynik;

    public Gracz(String imie) {
        this.imie = imie;
        this.wynik = 25;
    }

    public String getImie() {
        return imie;
    }

    public int getWynik() {
        return wynik;
    }

    public void setWynik(int wynik) {
        this.wynik = wynik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gracz gracz = (Gracz) o;
        return imie.equals(gracz.imie);
    }

    public int compareTo(Gracz gracz) {
        return this.wynik - gracz.wynik;
    }
}
