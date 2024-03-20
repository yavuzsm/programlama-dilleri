import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Özne, Nesne ve Yüklem dizilerini oluştur
        String[] subjects = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
        String[] objects = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma",
                "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
        String[] verbs = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};

        System.out.println("Cümleyi giriniz:");
        String sentence = scanner.nextLine();

        // Cümlenin kelimelerini ayırma
        String[] kelimeler = sentence.split("\\s+");

        // Cümlede en az 3 kelime olmalıdır (Özne, Nesne, Yüklem)
        if (kelimeler.length < 3) {
            System.out.println("HAYIR.");
            return;
        }

        // Özne, Nesne ve Yüklem kelimelerinin cümlede olup olmadığını kontrol et
        boolean degiskenOzne = false;
        boolean degiskenNesne = false;
        boolean degiskenYuklem = false;

        for (String kelime : kelimeler) {
            if (!degiskenOzne) {
                degiskenOzne = containsIgnoreCase(subjects, kelime);
            }
            if (!degiskenNesne) {
                degiskenNesne = containsIgnoreCase(objects, kelime);
            }
            if (!degiskenYuklem) {
                degiskenYuklem = containsIgnoreCase(verbs, kelime);
            }
        }

        if (degiskenOzne && degiskenNesne && degiskenYuklem) {
            System.out.println("EVET.");
        } else {
            System.out.println("HAYIR.");
        }
    }

    // Dizide belirtilen kelimenin olup olmadığını büyük-küçük harf duyarsız şekilde kontrol eden metod
    public static boolean containsIgnoreCase(String[] array, String key) {
        for (String item : array) {
            if (item.equalsIgnoreCase(key)) {
                return true;
            }
        }
        return false;
    }
}
