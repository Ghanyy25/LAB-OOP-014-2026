abstract class PerangkatElektronik {
    String merk;
    int dayaListrik;

    PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    abstract void cekFungsi();

    void infoPower() {
        System.out.println("Perangkat " + merk + " sedang menyedot daya sebesar " + dayaListrik + " Watt.");
    }
}

interface InteraksiInternet {
    void hubungkanWiFi();
}

interface KontrolSuara {
    void prosesPerintah(String perintah);
}

// SmartLamp 
class SmartLamp extends PerangkatElektronik implements KontrolSuara {
    SmartLamp(String merk, int daya) {
        super(merk, daya);
    }

    @Override
    void cekFungsi() {
        System.out.println("Fungsi: Pencahayaan Pintar.");
    }
 
    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        }
    }


}

// SmartCCTV 
class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {
    SmartCCTV(String merk, int daya) {
        super(merk, daya);
    }

    @Override
    void cekFungsi() {
        System.out.println("Fungsi: Pengawasan Keamanan.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server");
    }
}

// SmartSpeaker
class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {
    SmartSpeaker(String merk, int daya) {
        super(merk, daya);
    }

    @Override
    void cekFungsi() {
        System.out.println("Fungsi: Multimedia & Asisten Suara.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Smart Speaker terhubung ke internet.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Memproses perintah suara: " + perintah);
    }
}
