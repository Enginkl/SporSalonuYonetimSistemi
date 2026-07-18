package models;

public class VIPUye extends Uye{
    private Egitmen ozelHoca;

    public VIPUye(int id, String isim, int boy, int kilo, int kayitYili, Egitmen ozelHoca) {
        super(id, isim, boy, kilo, kayitYili);
        this.ozelHoca = ozelHoca;
    }

    @Override
    public double aidatHesapla() {
        return 1500.0;
    }

    public Egitmen getOzelHoca() {
        return ozelHoca;
    }

    public void setOzelHoca(Egitmen ozelHoca) {
        this.ozelHoca = ozelHoca;
    }

}
