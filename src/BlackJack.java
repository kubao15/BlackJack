import java.util.Scanner;

public class BlackJack {

    public static Gracz blackjack(Gracz gracz){
        Talia talia = new Talia();
        talia.budujTalie();
        talia.tasujTalie();

        Talia rekaKrupiera = new Talia();
        Talia rekaGracza = new Talia();
        int saldoBlackjack = gracz.getWynik();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj przy stole do BLackjacka, "+gracz.getImie()+"!");
        while (saldoBlackjack > 0) {
            boolean koniec = false;
            System.out.println("Ile chcesz postawić? (Wpisanie kwoty większej niż " +saldoBlackjack+ " spowoduje odejście od stołu)");
            double kwota = scanner.nextDouble();
            if (kwota > saldoBlackjack) {
                System.out.println("Dzięki za grę!");
                break;
            }

            rekaGracza.wyciagnijZTalii(talia);
            rekaGracza.wyciagnijZTalii(talia);
            rekaKrupiera.wyciagnijZTalii(talia);
            rekaKrupiera.wyciagnijZTalii(talia);

            while (!koniec) {
                System.out.println("Masz w ręce: \n" + rekaGracza);
                System.out.println("Wartośc kart w ręce: " + rekaGracza.wartosci());
//                System.out.println("");
//                System.out.println("Ręka krupiera: \n" + taliaKrupiera.toString());
//                System.out.println("Wartośc kart w ręce krupiera: " + taliaKrupiera.wartosci() +"\n");

                System.out.println("Dobierasz(1) czy pasujesz(2)?");
                int wybor = scanner.nextInt();
                switch (wybor) {
                    case 1:
                        rekaGracza.wyciagnijZTalii(talia);
                        System.out.println("Pobrałeś: " + rekaGracza.wezKarte(rekaGracza.wielkoscTalii() - 1));
                        if (rekaGracza.wartosci() > 21) {
                            System.out.println("Obecna wartość ręki to: " + rekaGracza.wartosci() + " Przegrywasz!");
                            saldoBlackjack -= kwota;
                            koniec = true;
                        }
                        break;
                    case 2:
                        System.out.println("Ręka krupiera: \n" +rekaKrupiera);
                        while (rekaKrupiera.wartosci() < 17){
                            rekaKrupiera.wyciagnijZTalii(talia);
                            System.out.println("Krupier pobrał: " +rekaKrupiera.wezKarte(rekaKrupiera.wielkoscTalii()-1).toString());
                        }
                        System.out.println("Wartośc kart w ręce krupiera: " + rekaKrupiera.wartosci() +"\n");
                        if (rekaKrupiera.wartosci() > rekaGracza.wartosci() && rekaKrupiera.wartosci() <= 21){
                            System.out.println("Krupier wygrywa!");
                            saldoBlackjack -= kwota;

                        } else if (rekaKrupiera.wartosci() == rekaGracza.wartosci()) {
                            System.out.println("Remis!");
                        }
                        else if (rekaKrupiera.wartosci() > 21 || rekaKrupiera.wartosci() < rekaGracza.wartosci()){
                            System.out.println("Gracz wygrywa!");
                            saldoBlackjack += kwota;
                        }
                        koniec = true;
                        break;
                    default:
                        System.out.println("Błędny wybór");
                        break;
                }
            }
            System.out.println("Masz na koncie: " +saldoBlackjack);
            rekaGracza.przeniesDoTalii(talia);
            rekaKrupiera.przeniesDoTalii(talia);

            if (saldoBlackjack <= 0){
                System.out.println("Nie masz pieniążków, koniec gry!");
            }
        }
            gracz.setWynik(saldoBlackjack);
            return gracz;
    }
}
