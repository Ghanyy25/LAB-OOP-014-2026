package Tuprak5.Soal2;

class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {
    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    public void cekFungsi() {
        System.out.println(merk + " - Fungsi: Speaker pintar dengan WiFi dan kontrol suara.");
    }

    public void hubungkanWiFi() {
        System.out.println(merk + " - Terhubung ke WiFi. Streaming siap dimulai!");
    }

    public void prosesPerintah(String perintah) {
        System.out.println(merk + " - Memproses perintah: " + perintah);
        System.out.println(merk + " - Perintah berhasil dieksekusi!");
    }
}
