package models;

import interfaces.IAntrenmanYapilabilir;

public abstract class Uye extends Kisi implements IAntrenmanYapilabilir {
    private int kayitYili;

    public Uye(int id, String isim, int boy, int kilo, int kayitYili) {
        super(id, isim, boy, kilo);
        this.kayitYili = kayitYili;
    }

    public abstract double aidatHesapla();

    @Override
    public void rolBildir() {
        System.out.println("Ben bu spor salonunun bir uyesiyim.");
    }

    public int getKayitYili() {
        return kayitYili;
    }

    @Override
    public double vkiHesapla() {
        double boyMetre = getBoy() / 100.0;

        return getKilo() / (boyMetre * boyMetre);
    }

    @Override
    public void antrenmanProgramiAta() {
        double vki = vkiHesapla();
        System.out.println("\n--- " + getIsim() + " İçin Antrenman Programı ---");
        System.out.printf("Güncel Vücut Kitle İndeksiniz: %.2f\n", vki);

        if (vki < 18.5) {
            System.out.println("Odak: Kilo Alma ve Hacim (Bulking)");
            System.out.println("Program: Haftada 4 gün ağır ağırlık antrenmanı, minimum kardiyo.");
        } else if (vki >= 18.5 && vki <= 24.9) {
            System.out.println("Odak: Koruma ve Güç (Strength)");
            System.out.println("Program: Haftada 3 gün tüm vücut (Full Body) güç antrenmanı, 1 gün kardiyo.");
        } else {
            System.out.println("Odak: Kilo Verme ve Yağ Yakımı (Definisyon)");
            System.out.println("Program: Haftada 4 gün yüksek tempolu antrenman (HIIT) ve ağırlık çalışması.");
        }
    }
}
