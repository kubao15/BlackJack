import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public abstract class Pliki {

    public static void pliczekZapis(String wejscie) {
        try {
            byte[] strToBytes = wejscie.getBytes();
            Files.write(Paths.get("C:\\Users\\rycer\\Desktop\\plik.txt"), strToBytes, StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pliczekOdczyt(){
        try {
            List<String> file = Files.readAllLines(Paths.get("C:\\Users\\rycer\\Desktop\\plik.txt"));
            file.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
