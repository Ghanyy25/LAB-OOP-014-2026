package Tuprak5.Soal1;

class KaryawanKontrak extends Karyawan {
    private double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    public double hitungGaji() {
        double totalGaji = this.upahPerHari * getJumlahKehadiran();
        if (getJumlahKehadiran() > 20) {
            totalGaji += 500000;
        }
        return totalGaji;
    }
}