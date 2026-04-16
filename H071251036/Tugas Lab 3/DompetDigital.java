class DompetDigital {

    private String pin;
    private double saldo;
    protected String idNasabah;
    String namaAplikasi;
    
    public DompetDigital(String idNasabah, String pin) {
        this.idNasabah = idNasabah;
        this.pin = pin;
        this.saldo = 0; 
        this.namaAplikasi = "E-WalletX";
    }
    public String getIdNasabah() {
        return idNasabah; 
    }
    public double getSaldo() {
        return saldo;
    }
    public void ubahPin(String pinLama, String pinBaru) {
        if (!this.pin.equals(pinLama)) {
            System.out.println("PIN lama salah! Perubahan ditolak.");
        } else if (pinBaru.length() != 6) {
            System.out.println("PIN baru harus 6 digit!");
        } else {
            this.pin = pinBaru;
            System.out.println("PIN berhasil diubah.");
        }
    }
    public void setor(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Setor gagal! Nominal tidak valid.");
            logTransaksi("Setor gagal");
        } else {
            saldo += jumlah;
            System.out.println("Setor berhasil: " + jumlah);
            logTransaksi("Setor berhasil");
        }
    }
    public void tarik(double jumlah, String inputPin) {
        if (!this.pin.equals(inputPin)) {
            System.out.println("PIN salah! Tarik ditolak.");
            logTransaksi("Tarik gagal (PIN salah)");
        } else if (jumlah > saldo) {
            System.out.println("Saldo tidak cukup!");
            logTransaksi("Tarik gagal (saldo kurang)");
        } else {
            saldo -= jumlah;
            System.out.println("Tarik berhasil: " + jumlah);
            logTransaksi("Tarik berhasil");
        }
    }
    private void logTransaksi(String pesan) {
        System.out.println("[LOG]: " + pesan);
    }
}