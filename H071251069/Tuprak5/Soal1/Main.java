package Tuprak5.Soal1;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== KARYAWAN TETAP ===");

        KaryawanTetap T = new KaryawanTetap("Reza", "DEV-025", 3000, 3000);

        for (int i = 0; i < 15; i++)
            T.absen();

        double gajiDasar = T.hitungGaji();
        double gajiDenganBonus = T.hitungGaji(1_500_000);

        System.out.println("\n--- Rekap Gaji ---");
        System.out.printf("Gaji tanpa bonus: Rp%,.0f%n", gajiDasar);
        System.out.printf("Gaji + bonus kinerja: Rp%,.0f%n", gajiDenganBonus);

        System.out.println("\n=== KARYAWAN KONTRAK ===");

        KaryawanKontrak kontrak = new KaryawanKontrak("Jiwono", "Za-069", 5000);

        for (int i = 0; i < 22; i++)
            kontrak.absen();

        double gajiKontrak = kontrak.hitungGaji();

        System.out.println("\n--- Rekap Gaji ---");
        System.out.printf("Total Gaji: Rp%,.0f%n", gajiKontrak);
    }
}
