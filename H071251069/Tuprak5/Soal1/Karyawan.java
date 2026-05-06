package Tuprak5.Soal1;

abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran;

    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    public void absen() {
        this.jumlahKehadiran++;
        System.out.println(this.nama + " masuk kerja. Total kehadiran: " + this.jumlahKehadiran + " hari.");
    }

    public String getNama() {
        return this.nama;
    }

    public String getIdKaryawan() {
        return this.idKaryawan;
    }

    public int getJumlahKehadiran() {
        return this.jumlahKehadiran;
    }

    public abstract double hitungGaji();
}
