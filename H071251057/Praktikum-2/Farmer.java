// 1.
public class Farmer {
    // Atribut
    String nama;
    int energi;
    Tanaman tanaman;

    // Constructor parameter
    // Data tanaman yang akan dirawat
    Farmer(String nama, int energi, Tanaman tanaman) {
        this.nama = nama;
        this.energi = energi;
        this.tanaman = tanaman;
    }
    // menyiram tanaman: energi -10 dan tinggi tanaman +5
    public void menyiram() {
        if (energi >= 10) {
            System.out.println(nama + " menyiram " + tanaman.namaTanaman);
            tanaman.tumbuh(5);
            energi -= 10;
        } else {
            System.out.println(nama + " kelelahan!");
        }
    }
    // membantu : Lily +10 energi, Daisy -5 energi
    public void kerjaBareng(Farmer teman) {
        if (energi >= 10) {
            System.out.println(nama + " membantu menyiram tanaman " + teman.nama);
            teman.energi += 10;
            energi -= 5;
        } else {
            System.out.println(nama + " kelelahan dan tidak bisa membantu!");
        }
        // System.out.println(nama + " membantu menyiram tanaman " + teman.nama);
        // teman.energi += 10;
        // energi -= 5;
    }

    public void panen() {
        if (tanaman.tinggi >= 25) {
            System.out.println(nama + " berhasil panen " + tanaman.namaTanaman + "!");
            tanaman.tinggi = 0;
        } else {
            System.out.println(nama + " belum bisa panen.");
        }
    }

    public void infoFarmer() {
        System.out.println("\nNama: " + nama);
        System.out.println("Energi: " + energi);
        tanaman.infoTanaman();
    }
}