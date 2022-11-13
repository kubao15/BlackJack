import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TabelaGraczy tabela = new TabelaGraczy();
        int i=0;
        while (i<5) {
            System.out.println("Podaj imię gracza: ");
            String imieGracza = scanner.next();
            Gracz gracz = new Gracz(imieGracza);
                if (!tabela.wyszukajImieGracza(gracz)) {
                    System.out.println("dodau!");
                    tabela.dodajGracza(gracz);
            }
                tabela.aktualizujGracza(BlackJack.blackjack(tabela.wyszukajGracza(imieGracza)), tabela.znajdzIndeksGracza(gracz));
            i++;
        }
        tabela.pokazTabele();
    }
    }

