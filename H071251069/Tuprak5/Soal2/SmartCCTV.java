package Tuprak5.Soal2;

class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {
    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    public void cekFungsi() {
        System.out.println(merk + " - Fungsi: Kamera pengawas dengan koneksi internet.");
    }

    public void hubungkanWiFi() {
        System.out.println(merk + " - Mengirim data ke server");
    }
}
