abstract class PerangkatElektronik { 
    String merk;
    int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    public abstract void cekFungsi();

    public void infoPower(){
        System.out.println(merk + " menggunakan daya sebesar " + dayaListrik + " watt");
    }
}

interface  InteraksiInternet {
    void hubungkanWifi();
}

interface KontrolSuara {
    void prosesPerintah(String perintah);
}
