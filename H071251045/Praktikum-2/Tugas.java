package Baru;

public class Tugas {
    String jenisTugas;
    int jumlahTugas;

    public Tugas(String jenisTugas, int jumlahTugas) {
        this.jenisTugas = jenisTugas;
        this.jumlahTugas = jumlahTugas;
    }

    public void tampilkanInfoTugas() {
        System.out.println("Anda memiliki Tugas " + jenisTugas + " sebanyak " + jumlahTugas + " soal");
    }
}