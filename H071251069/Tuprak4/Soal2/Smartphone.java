package Soal2;

public class Smartphone extends Produk {
    double ukuranLayar;
    int kapasitasPenyimpanan;

    public Smartphone(String merk, int nomorSeri, double harga, double ukuranLayar, int kapasitasPenyimpanan) {
        super(merk, nomorSeri, harga);
        this.ukuranLayar = ukuranLayar;
        this.kapasitasPenyimpanan = kapasitasPenyimpanan;
    }

    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Screen Size: " + ukuranLayar + " inches");
        System.out.println("Storage Capacity: " + kapasitasPenyimpanan + "GB");
    }
}