package Soal2;

public class Laptop extends Produk {
    int ukuranRam;
    String tipeProcessor;

    public Laptop(String merk, int nomorSeri, double harga, int ukuranRam, String tipeProcessor) {
        super(merk, nomorSeri, harga);
        this.ukuranRam = ukuranRam;
        this.tipeProcessor = tipeProcessor;
    }

    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("RAM Size: " + ukuranRam + "GB");
        System.out.println("Processor Type: " + tipeProcessor);
    }
}
