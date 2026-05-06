package Soal2;

public class Produk {
    String merk;
    int nomorSeri;
    double harga;

    public Produk(String merk, int nomorSeri, double harga) {
        this.merk = merk;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    public void tampilInfo() {
        System.out.println("Brand: " + merk);
        System.out.println("Serial Number: " + nomorSeri);
        System.out.println("Harga :RP" + harga);
    }

    public int getNomorSeri() {
        return nomorSeri;
    }
}