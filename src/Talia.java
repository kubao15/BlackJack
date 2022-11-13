import java.util.ArrayList;
import java.util.Random;

public class Talia {

    private ArrayList<Karta> karty;

    public Talia() {
        this.karty = new ArrayList<Karta>();
    }

    public void budujTalie(){
        for(Kolory kolor : Kolory.values()){
            for(Figury figura : Figury.values()){
                this.karty.add(new Karta(kolor, figura));
            }
        }
    }

    public void tasujTalie(){
        ArrayList<Karta> talia2 = new ArrayList<>();
        int liczba = 0;
        Random random = new Random();
        for(int i=0; i<this.karty.size(); i++){
            liczba = random.nextInt((this.karty.size()));  //generowanie liczby losowej ograniczonej 'od góry' wielkością talii
            talia2.add(this.karty.get(liczba));  //dodanie losowej karty do drugiej, tymczasowej talii
            this.karty.remove(liczba);  //usuwanie tej karty z pierwszej talii
        }
        this.karty = talia2;  //przepisanie talii z tymczasowej do głównej
    }

    public int wartosci(){ //zwraca wartość kart w ręce
        int wartosc = 0;
        int liczbaAsow = 0;

        for(Karta karta: this.karty){
            switch (karta.getFigura()){
                case DWÓJKA: wartosc+=2; break;
                case TRÓJKA: wartosc+=3; break;
                case CZWÓRKA: wartosc+=4; break;
                case PIĄTKA:  wartosc+=5; break;
                case SZÓSTKA: wartosc+=6; break;
                case SIÓDEMKA: wartosc+=7; break;
                case ÓSEMKA: wartosc+=8; break;
                case DZIEWIĄTKA: wartosc+=9; break;
                case DZIESIĄTKA: wartosc+=10; break;
                case WALET: wartosc+=10; break;
                case DAMA: wartosc+=10; break;
                case KRÓL: wartosc+=10; break;
                case AS: liczbaAsow+=1; break;
            }
        }
        for (int i=0; i<liczbaAsow; i++){
            if (wartosc>10){
                wartosc+=1;
            }
            else {
                wartosc+=11;
            }
        }
        return wartosc;
    }

    public void przeniesDoTalii(Talia talia){
        for(int i=0; i<this.karty.size(); i++){
            talia.dodajKarte(this.wezKarte(i));  //kopiuje karty z ręki do głównej talii
        }
        this.karty.clear();   //czyści rękę
    }

    public int wielkoscTalii(){
        return this.karty.size();
    }

    public void dodajKarte(Karta dodaj){
        this.karty.add(dodaj);
    }

    public Karta wezKarte(int i) {
        return this.karty.get(i);
    }

    public void usunKarte(int i){
        this.karty.remove(i);
    }

    public void wyciagnijZTalii(Talia talia){
        this.karty.add(talia.wezKarte(0));
        talia.usunKarte(0);
    }

    @Override
    public String toString() {
        String zmienna = "";
        int i=0;
        for (Karta karta : this.karty) {
            zmienna += karta;
        }
        return "" + zmienna;
    }
}
