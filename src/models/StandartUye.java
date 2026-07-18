package models;

public class StandartUye extends Uye{

    public StandartUye(int id, String isim, int boy, int kilo, int kayitYili) {
        super(id, isim, boy, kilo, kayitYili);
    }

    @Override
    public double aidatHesapla() {
        return 500.0;
    }

}
