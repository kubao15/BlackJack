public class Karta {
    private Kolory kolor;
    private Figury figura;

    public Karta(Kolory kolor, Figury figura) {
        this.kolor = kolor;
        this.figura = figura;
    }

    @Override
    public String toString() {
        return "" + figura + " " + kolor+ "\n";
    }

    public Kolory getKolor() {
        return kolor;
    }

    public Figury getFigura() {
        return figura;
    }
}
