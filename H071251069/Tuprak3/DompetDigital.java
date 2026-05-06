package Tp3;

public class DompetDigital {
    private String pin;
    private String nomorKTP;
    protected String namaPemilik;
    String statusAkun;
    private double saldo;

    public DompetDigital(String idNasabah, String pinAwal) {
        this.namaPemilik = "Nasabah-" + idNasabah;
        this.pin = pinAwal;
        this.nomorKTP = "KTP-" + idNasabah;
        this.saldo = 0.0;
        this.statusAkun = "Aktif";
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getStatusAkun() {
        return statusAkun;
    }

    public boolean setUbahpin(String pinLama, String pinBaru) {
        if (this.pin.equals(pinLama)) {
            if (pinBaru.length() == 6) {
                this.pin = pinBaru;
                logAktivitas("Berhasil mengubah PIN.");
                return true;
            } else {
                logAktivitas("Gagal ubah PIN: PIN baru harus 6 karakter.");
                return false;
            }
        } else {
            logAktivitas("Gagal ubah PIN: PIN lama tidak sesuai.");
            return false;
        }
    }

    public boolean setorTunai(double jumlah) {
        if (jumlah > 0) {
            this.saldo += jumlah;
            logAktivitas("Setor tunai berhasil: Rp " + jumlah);
            return true;
        } else {
            logAktivitas("Setor ditolak: Nominal tidak boleh minus atau nol.");
            return false;
        }
    }

    public boolean tarikTunai(double jumlah, String pinInput) {
        if (!this.pin.equals(pinInput)) {
            logAktivitas("Tarik ditolak: PIN salah.");
            return false;
        } else if (jumlah <= this.saldo) {
            this.saldo -= jumlah;
            logAktivitas("Tarik tunai berhasil: Rp " + jumlah);
            return true;
        } else {
            logAktivitas("Tarik ditolak: Saldo tidak mencukupi.");
            return false;
        }
    }

    public boolean transfer(double jumlah, String pinInput, DompetDigital tujuan) {
        if (!this.pin.equals(pinInput)) {
            logAktivitas("Transfer ditolak: PIN salah.");
            return false;
        } else if (jumlah <= this.saldo) {
            this.saldo -= jumlah;
            tujuan.TerimaDana(jumlah);
            logAktivitas("Transfer berhasil: Rp " + jumlah);
            return true;
        } else {
            logAktivitas("Transfer ditolak: Saldo tidak mencukupi.");
            return false;
        }
    }

    protected void TerimaDana(double jumlah) {
        this.saldo += jumlah;
    }

    private void logAktivitas(String pesan) {
        System.out.println("[SYSTEM LOG] " + pesan);
    }
}