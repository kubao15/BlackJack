import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabelaGraczy {

    private final List<Gracz> tabela;

    public TabelaGraczy() {
        this.tabela = new ArrayList<>();
    }

    public void dodajGracza(Gracz gracz) {
        this.tabela.add(gracz);
        System.out.println("dodano nowego gracza");
        System.out.println("wielkość tablicy2: " +this.tabela.size());
    }

    public void aktualizujGracza(Gracz gracz, int i) {
        this.tabela.set(i, gracz);
    }

    public int znajdzIndeksGracza(Gracz gracz){
        int zmienna = 0;
        for(int i=0; i<this.tabela.size(); i++) {
            if (gracz.getImie().equals(this.tabela.get(i).getImie())){
                zmienna = i;
                break;
            }
        }
        return zmienna;
    }

    public Gracz wyszukajGracza(String imieGracza) {
        int k =0;
        for (int i=0; i<this.tabela.size(); i++) {
            if (imieGracza.equals(this.tabela.get(i).getImie())) {
                k = i;
            }
        }
        return this.tabela.get(k);
    }

    public boolean wyszukajImieGracza(Gracz gracz){
        for (int i=0; i<this.tabela.size(); i++) {
            if (gracz.getImie().equals(this.tabela.get(i).getImie())) {
                System.out.println("Ten gracz już istnieje");
                return true;
            }
        }
        return false;
    }

    public void pokazTabele() {
        Collections.sort(this.tabela, Collections.reverseOrder());
        System.out.println("---Ranking graczy---");
        int i = 1;
        for (Gracz gracz : this.tabela) {
            String zmienna = i+ ". Imię: " +gracz.getImie()+ ", wynik: " +gracz.getWynik() + "\n";
            Pliki.pliczekZapis(zmienna);
            System.out.println(i+ ". Imię: " +gracz.getImie()+ ", wynik: " +gracz.getWynik());
            i++;
        }
    }
}
