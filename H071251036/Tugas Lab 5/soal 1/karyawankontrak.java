class KaryawanKontrak extends Karyawan {
    private double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    public double hitungGaji() {
        double total = upahPerHari * jumlahKehadiran;

        if (jumlahKehadiran > 20) {
            total += 500000; // bonus
        }

        return total;
    }
}