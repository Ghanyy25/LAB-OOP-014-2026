// 2.
public class Tanaman {
    // Atribut
    String namaTanaman;
    int tinggi;
    int umur;

    // Constructor default
    Tanaman() {
        namaTanaman = "Tanaman";
        tinggi = 0;
        umur = 0;
    }
    // Constructor parameter
    Tanaman(String namaTanaman, int tinggi, int umur) {
        this.namaTanaman = namaTanaman;
        this.tinggi = tinggi;
        this.umur = umur;
    }
    // Untuk menambah tinggi dan umur tanaman
    public void tumbuh(int tambahan) {
        tinggi += tambahan;
        umur += 1;
        System.out.println(namaTanaman + " tumbuh +" + tambahan);
    }
    // Untuk menampilkan informasi tanaman
    public void infoTanaman() {
        System.out.println("Tanaman: " + namaTanaman);
        System.out.println("Tinggi: " + tinggi);
        System.out.println("Umur: " + umur);
    }
}