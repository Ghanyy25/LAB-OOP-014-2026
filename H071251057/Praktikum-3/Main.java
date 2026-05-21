public class Main {
    public static void main(String[] args) {
        DompetDigital dompet = new DompetDigital("ICA028\n", "020899");
        System.out.println("===== " + dompet.nameApps + " =====");
        System.out.println("\nID Customer: " + dompet.getIdCust());
        // System.out.println("Saldo: " + dompet.getSaldo());

        dompet.setPin("222222", "PO0807"); // login gagal krn pin lama salah
        dompet.setPin("020899", "PO0807"); // pin lama benar, berhasil mengganti pin baru

        // dompet.menyetor(1000000); // berhasil menyetor 1 juta
        // dompet.menyetor(-20000); // gagal menyetor krn jumlahnya minus

        // dompet.menarik(500000, "020899"); // gagal menarik krn pin salah
        // dompet.menarik(500000, "PO0807"); // berhasil menarik 500 ribu

        // System.out.println("Sisa saldo: " + dompet.getSaldo());
    }   
}