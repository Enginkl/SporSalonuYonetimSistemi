import services.SporSalonuManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SporSalonuManager manager = new SporSalonuManager(scanner);
        int secim = -1;

        System.out.println("--- Vücut Geliştirme ve Spor Salonu Yönetim Sistemine Hoş Geldiniz ---");

        // Menünün sürekli ekranda kalması için while döngüsü
        while (secim != 0) {
            System.out.println("\n===== ANA MENÜ =====");
            System.out.println("1- Yeni Üye Ekle");
            System.out.println("2- Yeni Eğitmen Ekle");
            System.out.println("3- Üye Sil");
            System.out.println("4- Tüm Üyeleri Listele");
            System.out.println("5- Tüm Eğitmenleri Listele");
            System.out.println("0- Çıkış Yap");
            System.out.print("Lütfen yapmak istediğiniz işlemi seçin: ");

            // Kullanıcının harf girmesi gibi hataları engellemek için kontrol
            if (scanner.hasNextInt()) {
                secim = scanner.nextInt();
                scanner.nextLine();

                // Seçime göre ilgili Manager metodunu çağırıyoruz
                switch (secim) {
                    case 1:
                        manager.uyeEkle();
                        break;
                    case 2:
                        manager.egitmenEkle();
                        break;
                    case 3:
                        System.out.print("Sistemden silinecek üyenin ID numarasını girin: ");
                        int silinecekId = scanner.nextInt();
                        scanner.nextLine();
                        manager.uyeSil(silinecekId);
                        break;
                    case 4:
                        manager.tumUyeleriListele();
                        break;
                    case 5:
                        manager.tumEgitmenleriListele();
                        break;
                    case 0:
                        System.out.println("Sistemden başarıyla çıkış yapıldı. İyi antrenmanlar!");
                        break;
                    default:
                        System.out.println("[HATA] Lütfen menüde bulunan 0 ile 4 arasında bir numara tuşlayın.");
                }
            } else {
                System.out.println("[HATA] Geçersiz giriş! Lütfen bir sayı girin.");
                scanner.nextLine(); // Hatalı metin girdisini bellekten temizler
            }
        }

        scanner.close();
    }
}
