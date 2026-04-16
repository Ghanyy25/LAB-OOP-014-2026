public class Band {
    public static void main(String[] args) {
        // Membuat object alat musik
        AlatMusik gitar = new AlatMusik("Gitar", "Petik");
        AlatMusik drum = new AlatMusik("Drum", "Pukul");
        // Membuat object band
        BandMusik band1 = new BandMusik("The Rockers", 4, gitar);
        BandMusik band2 = new BandMusik("Beat Masters", 5, drum);
        // Menjalankan method
        band1.tampil();
        System.out.println();
        band2.tampil();
        System.out.println();
        // Interaksi antar objek
        band1.kolaborasi(band2);
    }
}