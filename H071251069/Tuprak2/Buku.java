package Tuprak2;

public class Buku {

    String judul;
    int tahunTerbit;
    Penulis penulis;

    public Buku() {
        this.judul = "Belum ditentukan";
        this.tahunTerbit = 2020;
        this.penulis = new Penulis();
    }

    public Buku(String judul, int tahunTerbit, Penulis penulis) {
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.penulis = penulis;
    }

    public void tampilkanInfo() {
        System.out.println("=== Informasi Buku ===");
        System.out.println("Judul: " + judul);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        System.out.print("Penulis: ");
        penulis.tampilkanData();
        System.out.println("====================");
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunterbit() {
        return tahunTerbit;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setTahunterbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public void bandingkanBuku(Buku bukuLain) {
        System.out.println("=== Perbandingan Buku ===");
        System.out.println("Buku 1: " + this.judul + " (" + this.tahunTerbit + ")");
        System.out.println("Buku 2: " + bukuLain.judul + " (" + bukuLain.tahunTerbit + ")");

        if (this.tahunTerbit > bukuLain.tahunTerbit) {
            System.out.println("Hasil: " + this.judul + " lebih baru terbit");
        } else if (this.tahunTerbit < bukuLain.tahunTerbit) {
            System.out.println("Hasil: " + bukuLain.judul + " lebih baru terbit");
        } else {
            System.out.println("Hasil: Kedua buku terbit di tahun yang sama");
        }
        System.out.println("=========================");
    }
}