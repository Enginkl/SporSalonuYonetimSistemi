package models;

public abstract class Kisi {
    private int id;
    private String isim;
    private int boy;
    private int kilo;

    public Kisi(int id, String isim, int boy, int kilo) {
        this.id = id;
        this.isim = isim;
        this.boy = boy;
        this.kilo = kilo;
    }

    public abstract void rolBildir();

    public int getId() {
        return id;
    }

    public String getIsim() {
        return isim;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    public int getKilo() {
        return kilo;
    }

    public void setKilo(int kilo) {
        this.kilo = kilo;
    }
}
