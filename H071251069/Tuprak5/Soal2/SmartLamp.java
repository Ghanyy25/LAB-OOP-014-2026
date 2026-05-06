package Tuprak5.Soal2;

class SmartLamp extends PerangkatElektronik implements KontrolSuara {
    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    public void cekFungsi() {
        System.out.println(merk + " - Fungsi: Lampu pintar dengan kontrol suara.");
    }

    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println(merk + " - Lampu berpijar!");
        } else {
            System.out.println(merk + " - Perintah tidak dikenali: " + perintah);
        }
    }
}
