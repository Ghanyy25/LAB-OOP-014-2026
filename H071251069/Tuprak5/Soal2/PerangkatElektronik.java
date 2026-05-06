package Tuprak5.Soal2;

abstract class PerangkatElektronik {
    protected String merk;
    protected int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    public abstract void cekFungsi();

    public void infoPower() {
        System.out.println(merk + " - Perangkat sedang menyedot daya sebesar " + dayaListrik + " Watt.");
    }

}
