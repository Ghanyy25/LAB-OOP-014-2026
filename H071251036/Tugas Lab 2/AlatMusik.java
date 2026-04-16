class AlatMusik {
    String namaAlat;
    String jenis;
    // Constructor default
    AlatMusik() {
        this.namaAlat = "Tidak diketahui";
        this.jenis = "Tidak diketahui";
    }
    // Constructor dengan parameter
    AlatMusik(String namaAlat, String jenis) {
        this.namaAlat = namaAlat;
        this.jenis = jenis;
    }
    void tampilkanAlat() {
        System.out.println("Alat Musik: " + namaAlat + " (" + jenis + ")");
    }
}