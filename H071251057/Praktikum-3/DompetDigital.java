class DompetDigital {
    private String pin;
    private  double saldo;
    protected String idCust;
    String nameApps;

    public DompetDigital(String idCust, String pin) {
        this.idCust = idCust; 
        this.pin = pin; 
        this.saldo = 0; 
        this.nameApps = "My E-Wallet";
    }

    public String getIdCust() {
        return idCust;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setPin(String oldPin, String newPin) {         
        boolean besar = false; 
        boolean kecil = false;
        for (int i = 0; i < newPin.length(); i++) {
                char c = newPin.charAt(i); //mengecek 1/1 karakter
                if (c >= 'A' && c <= 'Z') { 
                    besar = true;
                } else if (c >= 'a' && c <= 'z') {
                    kecil = true;
                }
            }
        if (!this.pin.equals(oldPin)){ // mengecek apakah pin lama benar
            System.out.println("Gagal: PIN lama salah!"); 
        } else if (newPin.length() != 6) {
            System.out.println("Gagal: PIN baru harus terdiri dari 6 digit!");
        } else if (!(besar && kecil)) {
            System.out.println("Gagal: PIN baru harus mengandung huruf besar dan kecil!");
        } else {
            this.pin = newPin;
            System.out.println("PIN berhasil diubah!");
            logTransaksi("PIN berhasil diubah!");
        }
    }

    public void menyetor(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Gagal: Jumlah setor tidak valid!");
            logTransaksi("Transaksi gagal: Jumlah setor tidak valid!");
        } else {
            this.saldo += jumlah;
            System.out.println("Transaksi penyetoran sebesar " + jumlah + " berhasil!");
            logTransaksi("Penyetoran berhasil!");
        }
    }

    public void menarik(double jumlah, String pinInput) {
        if (!this.pin.equals(pinInput)) {
            System.out.println("Login gagal: PIN salah!");
            logTransaksi("Transaksi gagal: PIN salah!");
        } else if (jumlah > saldo) {
            System.out.println("Gagal: Saldo tidak cukup!");
            logTransaksi("Transaksi gagal: Saldo tidak cukup!");
        } else if (jumlah <= 0) {
            System.out.println("Gagal: Jumlah penarikan tidak valid!");
            logTransaksi("Transaksi gagal: Jumlah penarikan tidak valid!");
        } else {
            saldo -= jumlah;
            System.out.println("Transaksi penarikan sebesar " + jumlah + " berhasil!");
            logTransaksi("Penarikan berhasil!");
        }
    }

    public void logTransaksi(String message) {
        System.out.println("[LOG]: " + message + "\n");
    }
}