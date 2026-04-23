class Produk {
    String merek;
    String nomorSeri;
    double harga;

    Produk(String merek, String nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    void tampilkanInfo() {
        System.out.println("Merek: " + merek);
        System.out.println("Nomor Seri: " + nomorSeri);
        System.out.println("Harga: " + harga);
    }
}