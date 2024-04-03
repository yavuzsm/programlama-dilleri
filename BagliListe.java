import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class BagliListeElemani {
    int veri;
    BagliListeElemani next;

    BagliListeElemani(int v) {
        veri = v;
        next = null;
    }
}

public class BagliListe {
    private BagliListeElemani bas;

    public BagliListe() {
        bas = null;
    }

    public void ekle(int veri) {
        BagliListeElemani yeniEleman = new BagliListeElemani(veri);
        if (bas == null) {
            bas = yeniEleman;
        } else {
            BagliListeElemani temp = bas;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = yeniEleman;
        }
    }

    public void sirala() {
        BagliListeElemani current = bas;
        BagliListeElemani index = null;
        int temp;

        if (bas == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;

                while (index != null) {
                    if (current.veri > index.veri) {
                        temp = current.veri;
                        current.veri = index.veri;
                        index.veri = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public void yazdir() {
        BagliListeElemani temp = bas;
        while (temp != null) {
            System.out.print(temp.veri + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        BagliListe liste = new BagliListe();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Dosya adını girin: ");
        String dosyaAdi = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi));
            String satir;

            while ((satir = reader.readLine()) != null) {
                int sayi = Integer.parseInt(satir);
                liste.ekle(sayi);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Dosya okuma hatasi: " + e.getMessage());
        }

        liste.sirala();
        liste.yazdir();
    }
}
