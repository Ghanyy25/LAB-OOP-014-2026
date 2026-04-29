public class MainSoal1 {
    public static void main(String[] args) {

        // Karyawan Tetap
        KaryawanTetap kt = new KaryawanTetap("Budi", "KT01", 5000000, 20000);
        for (int i = 0; i < 22; i++) {
            kt.absen();
        }
        System.out.println("Gaji Karyawan Tetap + Bonus: " + kt.hitungGaji(1000000));

        // Karyawan Kontrak
        KaryawanKontrak kk = new KaryawanKontrak("Andi", "KK01", 150000);
        for (int i = 0; i < 25; i++) {
            kk.absen();
        }
        System.out.println("Gaji Karyawan Kontrak: " + kk.hitungGaji());
    }
}