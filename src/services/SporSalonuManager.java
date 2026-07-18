package services;

import models.Uye;
import models.Egitmen;
import models.StandartUye;
import models.VIPUye;

import java.util.ArrayList;
import java.util.Scanner;

public class SporSalonuManager {
    private ArrayList<Uye> uyeler;
    private ArrayList<Egitmen> egitmenler;
    private Scanner scanner;
    private int currentYear;

    private int sonrakiUyeId = 1;
    private int sonrakiEgitmenId = 101;

    public SporSalonuManager() {
        this.uyeler = new ArrayList<>();
        this.egitmenler = new ArrayList<>();

        this.currentYear = 2026;

        scanner = new Scanner(System.in);
        varsayilanVerileriYukle();
    }

    private void varsayilanVerileriYukle() {
        // --- 2 EĞİTMEN ---
        Egitmen egitmen1 = new Egitmen(sonrakiEgitmenId++, "Kaan Aslan", 180, 85);
        Egitmen egitmen2 = new Egitmen(sonrakiEgitmenId++, "Merve Şahin", 170, 60);
        egitmenler.add(egitmen1);
        egitmenler.add(egitmen2);

        // --- 3 STANDART ÜYE ---
        uyeler.add(new StandartUye(sonrakiUyeId++, "Ahmet Yılmaz", 175, 75, 2025));
        uyeler.add(new StandartUye(sonrakiUyeId++, "Zeynep Demir", 168, 60, 2026));
        uyeler.add(new StandartUye(sonrakiUyeId++, "Mehmet Kaya", 182, 80, 2025));

        // --- 3 VIP ÜYE ---
        if (egitmen1.ogrenciEkle()) {
            uyeler.add(new VIPUye(sonrakiUyeId++, "İsmail Engin Kılıç", 186, 100, 2026, egitmen1));
        }
        if (egitmen1.ogrenciEkle()) {
            uyeler.add(new VIPUye(sonrakiUyeId++, "Burak Çelik", 178, 82, 2026, egitmen1));
        }
        if (egitmen2.ogrenciEkle()) {
            uyeler.add(new VIPUye(sonrakiUyeId++, "Ayşe Yıldız", 165, 55, 2025, egitmen2));
        }
    }

    public void uyeEkle(){
        System.out.println("--- YENI UYE KAYDI ---");
        System.out.print("Ad Soyad: ");
        String adSoyad = scanner.nextLine();

        System.out.print("Boy (cm): ");
        int boy =  scanner.nextInt();

        System.out.print("Kilo (kg): ");
        int kilo = scanner.nextInt();

        System.out.println("\n1- Standart Uye\n2- VIP Uye");
        System.out.print("\n Eklenecek Uye Turunu Secin: ");
        int uyeTuru =  scanner.nextInt();

        if(uyeTuru == 1){
            StandartUye yeniStandart = new StandartUye(sonrakiUyeId++,adSoyad,boy,kilo,currentYear);
            uyeler.add(yeniStandart);
            System.out.println("[BASARILI] " + adSoyad + " sisteme Standart Uye olarak eklendi. ID: " + (sonrakiUyeId - 1));
        }
        else if(uyeTuru == 2){
            System.out.println("Ozel Hocalar:");
            for(int i=0;i<egitmenler.size();i++){
                Egitmen hoca = egitmenler.get(i);
                System.out.println((i+1) + "- " + hoca.getIsim() + " (Kontenjan: " + hoca.getSorumluOlduguKisiSayisi() + "/5)");
            }
            System.out.println("Lutfen atamak istediginiz ozel hocayi secin: ");
            int hocaSecim = scanner.nextInt();
            scanner.nextLine();

            Egitmen secilenHoca = egitmenler.get(hocaSecim-1);

            if(secilenHoca.ogrenciEkle()){
                VIPUye yeniVip = new VIPUye(sonrakiUyeId++,adSoyad,boy,kilo,currentYear,secilenHoca);
                uyeler.add(yeniVip);
                System.out.println("[BASARILI] " + adSoyad + " VIP Uye olarak eklendi. ID: " + (sonrakiUyeId - 1));
                System.out.println("Atanan Hoca: " + secilenHoca.getIsim());
            }
            else {
                System.out.println("[HATA] " + secilenHoca.getIsim() + " adli hocanin 5 kisilik kontenjani doludur. Kayit yapilamadi.");
            }
        }
        else {
            System.out.println("[HATA] Gecersiz uye turu sectiniz. Kayit iptal edildi.");
        }
    }

    public void egitmenEkle(){
        System.out.println("--- YENI EGITMEN KAYDI ---");
        System.out.print("Ad Soyad: ");
        String adSoyad = scanner.nextLine();

        System.out.print("Boy (cm): ");
        int boy =  scanner.nextInt();
        System.out.print("Kilo (kg): ");
        int kilo = scanner.nextInt();

        Egitmen yeniEgitmen = new Egitmen(sonrakiEgitmenId++,adSoyad,boy,kilo);
        egitmenler.add(yeniEgitmen);
        System.out.println("[BASARILI] " +  adSoyad + " sisteme egitmen olarak eklendi. ID: " + (sonrakiEgitmenId - 1));
    }

    public void uyeSil(int id){
        for(int i=0;i<uyeler.size();i++){
            if(uyeler.get(i).getId() == id){
                System.out.println("[SILINDI] " + uyeler.get(i).getIsim() + " sistemden cikarildi.");
                uyeler.remove(i);
                return;
            }
        }
    }

    public void tumUyeleriListele(){
        System.out.println("\n--- GUNCEL UYE LISTESI --- ");

        for(Uye uye : uyeler){
            System.out.println("ID: " + uye.getId() + " | Isim: " + uye.getIsim());
            System.out.println("Boy: (cm): " + uye.getBoy() + "\nKilo (kg): " + uye.getKilo());
            System.out.println("Aidat: " + uye.aidatHesapla() + " TL");

            if(uye instanceof StandartUye){
                System.out.println("Uyelik Turu: Standart Uye");
            }

            if(uye instanceof VIPUye){
                VIPUye vip = (VIPUye) uye;
                System.out.println("Uyelik Turu: VIP Uye");
                System.out.println("Ozel Hocasi: " + vip.getOzelHoca().getIsim());
            }
            System.out.println();
        }
        System.out.println("----------------------------\n");
    }

    public void tumEgitmenleriListele(){
        System.out.println("\n--- GUNCEL EGITMEN LISTESI --- ");
        for(Egitmen egitmen : egitmenler){
            System.out.println("ID: " + egitmen.getId() + "  | Isim: " + egitmen.getIsim());
            System.out.println("Boy (cm): " + egitmen.getBoy() + "\nKilo (kg): " + egitmen.getKilo());
            System.out.println("Kontenjan: " + (5 - egitmen.getSorumluOlduguKisiSayisi()) + "/5");
            System.out.println();
        }
        System.out.println("----------------------------\n");
    }

    public ArrayList<Uye> getUyeler() {
        return uyeler;
    }

    public ArrayList<Egitmen> getEgitmenler() {
        return egitmenler;
    }

}
