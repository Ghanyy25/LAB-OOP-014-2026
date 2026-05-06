package Tp3;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PENGUJIAN SISTEM DOMPET DIGITAL ===\n");
        DompetDigital dompet1 = new DompetDigital("12345", "111111");
        DompetDigital dompet2 = new DompetDigital("12346", "111112");
        System.out.println("1. Info Akun:");
        System.out.println("   Nama: " + dompet1.getNamaPemilik());
        System.out.println("   Status: " + dompet1.getStatusAkun());
        System.out.println();
        System.out.println("2. Coba ubah PIN (PIN lama salah):");
        dompet1.setUbahpin("999999", "222222");
        System.out.println();
        System.out.println("3. Coba ubah PIN (Data benar):");
        dompet1.setUbahpin("111111", "222222");
        System.out.println();
        System.out.println("4. Setor tunai Rp 500.000:");
        dompet1.setorTunai(500000);
        System.out.println();
        System.out.println("5. Coba setor tunai Rp -50.000:");
        dompet1.setorTunai(-50000);
        System.out.println();
        System.out.println("6. Tarik tunai Rp 50.000 (PIN lama):");
        dompet1.tarikTunai(50000, "111111");
        System.out.println();
        System.out.println("7. Tarik tunai Rp 50.000 (PIN baru):");
        dompet1.tarikTunai(50000, "222222");
        System.out.println();
        System.out.println("8. Saldo Akhir:");
        System.out.println("   Sisa Saldo: Rp " + dompet1.getSaldo());
        System.out.println("\n=== PENGUJIAN SELESAI ===");
        dompet1.transfer(10000, "222222", dompet2);
        System.out.println("Saldo Pertama: " + dompet1.getSaldo());
        System.out.println("Saldo Kedua: " + dompet2.getSaldo());
    }
}