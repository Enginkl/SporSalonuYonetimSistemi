package models;

public class Egitmen extends Kisi{
    private int sorumluOlduguKisiSayisi;
    private final int MAX_KONTENJAN = 5;

    public Egitmen(int id, String isim, int boy, int kilo) {
        super(id, isim, boy, kilo);
        sorumluOlduguKisiSayisi = 0;
    }

    public boolean ogrenciEkle(){
        if(sorumluOlduguKisiSayisi < MAX_KONTENJAN){
            sorumluOlduguKisiSayisi++;
            return true; //kontenjan boş, kayıt başarılı
        }
        return false;  //kontenjan dolu, kayıt başarısız
    }

    @Override
    public void rolBildir() {
        System.out.println("Ben bu spor salonunda bir egitmenim. " + sorumluOlduguKisiSayisi + " kisiden sorumluyum.");
    }

    public int getSorumluOlduguKisiSayisi() {
        return sorumluOlduguKisiSayisi;
    }

}
