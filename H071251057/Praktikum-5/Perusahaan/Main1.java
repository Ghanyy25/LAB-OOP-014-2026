public class Main1 {
   public static void main(String[] args) {
        KaryawanTetap kt = new KaryawanTetap("Ryul", "4SHO18", 5000000, 40000);

        for (int i = 0; i < 22; i++){
            kt.absen();
        }

        System.out.println("=== Karyawan Tetap ===");
        System.out.println("Nama: " + kt.getNama());
        System.out.println("Kehadrian: " + kt.getJumlahKehadiran());
        System.out.println("Total Gaji: " + kt.hitungGaji(2500000));
        // 5jt + (40rb * 22) + 2.5jt = 8.38jt

        KaryawanKontrak kk = new KaryawanKontrak ("Ohyul", "4SHO21", 150000);

        for(int i = 0; i < 21; i++){
            kk.absen();
        }

        System.out.println("\n=== Karyawan Kontrak 1 ===");
        System.out.println("Nama: " + kk.getNama());
        System.out.println("Kehadiran: " + kk.getJumlahKehadiran());
        System.out.println("Total Gaji: " + kk.hitungGaji());
        // (150rb * 21) + 500rb = 3.65jt

        KaryawanKontrak kk2 = new KaryawanKontrak ("Louis", "4SHO01", 150000);

        for(int i = 0; i < 18; i++){
            kk2.absen();
        }

        System.out.println("\n=== Karyawan Kontrak 2 ===");
        System.out.println("Nama: " + kk2.getNama());
        System.out.println("Kehadiran: " + kk2.getJumlahKehadiran());
        System.out.println("Total Gaji: " + kk2.hitungGaji());
        // (150rb * 18) = 2.7jt
   } 
}