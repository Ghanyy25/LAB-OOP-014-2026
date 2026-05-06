package Tuprak2;

public class Penulis {
    String nama;
    String negara;

    public Penulis() {
        this.nama = "Tidak diketahui";
        this.negara = "Indonesia";
    }

    public Penulis(String nama, String negara) {
        this.nama = nama;
        this.negara = negara;
    }

    public void tampilkanData() {
        System.out.println(nama + " (" + negara + ")");
    }

    public String getNegara() {
        return negara;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }
}