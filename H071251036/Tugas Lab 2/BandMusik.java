class BandMusik {
    String namaBand;
    int jumlahMember;
    AlatMusik alat; // atribut berupa object
    // Constructor default
    BandMusik() {
        this.namaBand = "Band Tanpa Nama";
        this.jumlahMember = 0;
        this.alat = new AlatMusik();
    }
    // Constructor dengan parameter
    BandMusik(String namaBand, int jumlahMember, AlatMusik alat) {
        this.namaBand = namaBand;
        this.jumlahMember = jumlahMember;
        this.alat = alat;
    }
    // Method 1
    void tampil() {
        System.out.println("Band " + namaBand + " sedang tampil!");
        System.out.println("Jumlah member: " + jumlahMember);
        alat.tampilkanAlat();
    }
    // Method 2 (interaksi antar objek)
    void kolaborasi(BandMusik bandLain) {
        System.out.println(namaBand + " berkolaborasi dengan " + bandLain.namaBand);
        System.out.println("Mereka memainkan alat musik masing-masing!");
    }
}