class Smartphone extends Produk {
    double ukuranLayar;
    int storage;

    Smartphone(String merek, String nomorSeri, double harga, double ukuranLayar, int storage) {
        super(merek, nomorSeri, harga);
        this.ukuranLayar = ukuranLayar;
        this.storage = storage;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ukuran Layar: " + ukuranLayar);
        System.out.println("Storage: " + storage);
    }
}

class Laptop extends Produk {
    String processor;

    Laptop(String merek, String nomorSeri, double harga, String processor) {
        super(merek, nomorSeri, harga);
        this.processor = processor;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Processor: " + processor);
    }
}

class Kamera extends Produk {
    int megapixel;

    Kamera(String merek, String nomorSeri, double harga, int megapixel) {
        super(merek, nomorSeri, harga);
        this.megapixel = megapixel;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Megapixel: " + megapixel);
    }
}